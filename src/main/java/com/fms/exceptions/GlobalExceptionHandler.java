package com.fms.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AirportCodeNotFoundException.class)
    public String handlingMethod(AirportCodeNotFoundException e)
    {
        return "Code Not Found Exception"+":"+e.getMessage();
    }
}