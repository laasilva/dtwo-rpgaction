package com.dtwo.rpgaction.exception;

import com.dtwo.rpgaction.utils.Constants;
import org.springframework.http.HttpStatus;

public class GeneralControllerException extends RuntimeException {
    private HttpStatus status;

    public GeneralControllerException(String message) { super(Constants.GENERIC_CONTROLLER_ERROR + message); }

    public GeneralControllerException(String message, Throwable throwable) { super(Constants.GENERIC_CONTROLLER_ERROR + message, throwable); }

    public GeneralControllerException(String message, HttpStatus status) {
        super(Constants.GENERIC_CONTROLLER_ERROR + message);
        this.status = status;
    }

    public GeneralControllerException(String message, Throwable throwable, HttpStatus status) {
        super(Constants.GENERIC_CONTROLLER_ERROR + message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
