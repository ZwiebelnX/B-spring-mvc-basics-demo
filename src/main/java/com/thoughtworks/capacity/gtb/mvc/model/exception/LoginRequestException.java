package com.thoughtworks.capacity.gtb.mvc.model.exception;

import org.springframework.http.HttpStatus;

public class LoginRequestException extends BusinessBasicException {

    public LoginRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
