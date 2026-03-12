package com.nikita.usermanagement.exception;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return e.getMessage();
    }

}