package com.dtwo.rpgaction.scopes.commons;

import com.dtwo.rpgaction.exception.ScopeContextException;
import com.dtwo.rpgaction.model.commons.ScopeContext;
import com.dtwo.rpgaction.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public abstract class BaseScopeItem {

    @Autowired
    public ScopeContext context;

    public BaseScopeItem() {}

    public Object execute(Object currentPayload) throws ScopeContextException {
        if (currentPayload != null) {
            context.setCurrentPayload(currentPayload);
            context.addToScopePayload(currentPayload.getClass().getCanonicalName(), currentPayload);
        } else {
            throw new ScopeContextException(Constants.PAYLOAD_SCOPE_ERROR, HttpStatus.PRECONDITION_FAILED);
        }

        return this.processor(currentPayload, context);
    }

    public void doExecute(Object currentPayload) throws ScopeContextException {
        if (currentPayload != null) {
            context.setCurrentPayload(currentPayload);
            context.addToScopePayload(currentPayload.getClass().getCanonicalName(), currentPayload);
        } else {
            throw new ScopeContextException(Constants.PAYLOAD_SCOPE_ERROR, HttpStatus.PRECONDITION_FAILED);
        }
    }

    public abstract Object processor(Object currentPayload, ScopeContext context);
}
