package com.dtwo.rpgaction.scopes.commons;

import com.dtwo.rpgaction.exception.ScopeContextException;

public interface BaseScope {
    Object execute(Object currentPayload) throws ScopeContextException;
}
