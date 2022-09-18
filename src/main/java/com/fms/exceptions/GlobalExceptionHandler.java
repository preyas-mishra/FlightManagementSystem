package com.fms.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AirportIdNotFoundException.class)
    public String handlingMethod(AirportIdNotFoundException e)
    {
        return "Code Not Found Exception"+":"+e.getMessage();
    }
	
	@ExceptionHandler(ScheduleIdNotFoundException.class)
    public String handlerForIdNotFoundException(ScheduleIdNotFoundException e)
    {
        return "Schedule Id Not Found Exception :"+e.getMessage();
    }
}