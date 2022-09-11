package com.master.common.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException implements IException{

    private final HttpStatus statusCode;

    public ValidationException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
