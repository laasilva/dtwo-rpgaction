package com.dtwo.rpgaction.scopes.baseCommons;

import com.dtwo.rpgaction.exception.ScopeContextException;
import com.dtwo.rpgaction.model.commons.ScopeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScopeProcessor extends BaseScopeItem {

    @Autowired
    public ScopeContext context;

    @Autowired
    private List<BaseScopeItem> itens;

    public ScopeProcessor(List<BaseScopeItem> itens) {
        this.itens = itens;
    }

    public Object execute(Object currentPayload) throws ScopeContextException {
        context.setCurrentPayload(currentPayload);
        context.addToScopePayload(currentPayload.getClass().getCanonicalName(), currentPayload);

        return this.processor(currentPayload, context);
    }

    @Override
    public Object processor(Object currentPayload, ScopeContext context) {
        if(this.itens.size() > 1) {
            for (int i = 1; i < this.itens.size(); ++i) {
                if(!(itens.get(i) instanceof ScopeProcessor)) {
                    Object payload = itens.get(i).processor(currentPayload, context);
                    super.doExecute(payload);
                }
            }
        } else {
            Object payload = itens.get(0).processor(currentPayload, context);
            super.doExecute(payload);
        }

        return this.context.getCurrentPayload();
    }

    public List<BaseScopeItem> getItens() {
        return itens;
    }
}
