package com.dtwo.rpgaction.exception;

import com.dtwo.rpgaction.utils.Constants;
import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
    private HttpStatus status;

    public ValidationException(String message) { super(Constants.GENERIC_VALIDATION_ERROR + message); }

    public ValidationException(String message, Throwable throwable) { super(Constants.GENERIC_VALIDATION_ERROR + message, throwable); }

    public ValidationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ValidationException(String message, Throwable throwable, HttpStatus status) {
        super(Constants.GENERIC_VALIDATION_ERROR + message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
