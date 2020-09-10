package com.thoughtworks.capacity.gtb.mvc.model.exception;

import org.springframework.http.HttpStatus;

public class UserConflictException extends BusinessBasicException {

    public UserConflictException(String name) {
        super(HttpStatus.CONFLICT, "用户名<" + name + ">已存在");
    }
}
