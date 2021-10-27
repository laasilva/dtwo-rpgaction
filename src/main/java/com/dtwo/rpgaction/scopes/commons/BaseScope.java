package com.dtwo.rpgaction.scopes.commons;

import com.dtwo.rpgaction.exception.ScopeContextException;
import com.dtwo.rpgaction.model.commons.ScopeContext;

public interface BaseScope {
    Object execute(Object currentPayload) throws ScopeContextException;
}
