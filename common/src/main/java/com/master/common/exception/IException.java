package com.master.common.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

@JsonSerialize(as = IException.class)
public interface IException {
    HttpStatus getStatusCode();

    String getMessage();

}
