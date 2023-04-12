package com.itheima.day07.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class,CustomException.class})
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error(e.getMessage());
    }
}
