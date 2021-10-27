package com.dtwo.rpgaction.exception;

import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.http.HttpStatus;

public class ScopeContextException extends RuntimeException {

    private HttpStatus status;

    public ScopeContextException(String message) { super(AppConstants.GENERIC_SCOPE_ERROR + message); }

    public ScopeContextException(String message, Throwable throwable) { super(AppConstants.GENERIC_SCOPE_ERROR + message, throwable); }

    public ScopeContextException(String message, HttpStatus status) {
        super(AppConstants.GENERIC_SCOPE_ERROR + message);
        this.status = status;
    }

    public ScopeContextException(String message, Throwable throwable, HttpStatus status) {
        super(AppConstants.GENERIC_SCOPE_ERROR + message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
