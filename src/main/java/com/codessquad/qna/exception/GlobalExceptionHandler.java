package com.codessquad.qna.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotLoginException.class)
    public String handleNotLoginException() {
        return "/error/404";
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public String handleNotFoundEntityException() {
        return "/error/404";
    }
}
