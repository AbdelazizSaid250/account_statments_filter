package com.master.common.exception;

import org.springframework.http.HttpStatus;

public class NotNumberException extends ValidationException {

    public NotNumberException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public NotNumberException(String message, HttpStatus statusCode) {
        super(message, statusCode);
    }
}
