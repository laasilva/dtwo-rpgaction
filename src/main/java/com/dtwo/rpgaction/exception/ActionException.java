package com.dtwo.rpgaction.exception;

import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.http.HttpStatus;

public class ActionException extends RuntimeException {

    private HttpStatus status;

    public ActionException(String message) { super(AppConstants.GENERIC_ACTION_ERROR + message); }

    public ActionException(String message, Throwable throwable) { super(AppConstants.GENERIC_ACTION_ERROR + message, throwable); }

    public ActionException(String message, HttpStatus status) {
        super(AppConstants.GENERIC_ACTION_ERROR + message);
        this.status = status;
    }

    public ActionException(String message, Throwable throwable, HttpStatus status) {
        super(AppConstants.GENERIC_ACTION_ERROR + message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
