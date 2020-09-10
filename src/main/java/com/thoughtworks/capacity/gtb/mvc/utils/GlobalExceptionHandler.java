package com.thoughtworks.capacity.gtb.mvc.utils;

import com.thoughtworks.capacity.gtb.mvc.model.Error;
import com.thoughtworks.capacity.gtb.mvc.model.exception.BusinessBasicException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> validExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            stringBuilder.append(error.getDefaultMessage()).append(" ");
        }
        return new ResponseEntity<>(Error.builder().message(stringBuilder.toString()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessBasicException.class)
    public ResponseEntity<Error> businessExceptionHandler(BusinessBasicException e) {
        return new ResponseEntity<>(Error.builder().message(e.getMessage()).build(), e.getHttpStatus());
    }

}
