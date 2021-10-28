package com.dtwo.rpgaction.exception;

import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.http.HttpStatus;

public class GeneralControllerException extends RuntimeException {
    private HttpStatus status;

    public GeneralControllerException(String message) { super(AppConstants.GENERIC_CONTROLLER_ERROR + message); }

    public GeneralControllerException(String message, Throwable throwable) { super(AppConstants.GENERIC_CONTROLLER_ERROR + message, throwable); }

    public GeneralControllerException(String message, HttpStatus status) {
        super(AppConstants.GENERIC_CONTROLLER_ERROR + message);
        this.status = status;
    }

    public GeneralControllerException(String message, Throwable throwable, HttpStatus status) {
        super(AppConstants.GENERIC_CONTROLLER_ERROR + message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
