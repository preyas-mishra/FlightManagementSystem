package com.fms.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AirportIdNotFoundException.class)
    public String handlingMethod(AirportIdNotFoundException e)
    {
        return "Id Not Found Exception"+":"+e.getMessage();
    }
	
	@ExceptionHandler(AirportCodeNotFoundException.class)
    public String handlingMethod(AirportCodeNotFoundException e)
    {
        return "Code Not Found Exception"+":"+e.getMessage();
    }
	
	@ExceptionHandler(ScheduleIdNotFoundException.class)
    public String handlerForIdNotFoundException(ScheduleIdNotFoundException e)
    {
        return "Schedule Id Not Found Exception :"+e.getMessage();
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handlerMethodForException(MethodArgumentNotValidException ex)
    {
        Map<String,String> errorMessage=new LinkedHashMap<>();
        List<ObjectError> list=ex.getAllErrors();
        list.forEach(obj->{
            FieldError ferr=(FieldError)obj;
            String fname=ferr.getField();
            String msg=ferr.getDefaultMessage();
            errorMessage.put(fname, msg);
        });
        return errorMessage;
    }
}