package com.dtwo.rpgaction.exception;

import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
    private HttpStatus status;

    public ValidationException(String message) { super(AppConstants.GENERIC_VALIDATION_ERROR + message); }

    public ValidationException(String message, Throwable throwable) { super(AppConstants.GENERIC_VALIDATION_ERROR + message, throwable); }

    public ValidationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ValidationException(String message, Throwable throwable, HttpStatus status) {
        super(AppConstants.GENERIC_VALIDATION_ERROR + message, throwable);
        this.status = status;
    }

    public HttpStatus getStatus() { return status; }
}
