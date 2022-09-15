package com.fms.exceptions;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookingIdNotFoundException.class)
    public String handlingMethod(BookingIdNotFoundException e)
    {
        return "IdNotFoundException"+":"+e.getMessage();
    }
    
    @ExceptionHandler(NoOfPassengersException.class)
    public String handlingMethod(NoOfPassengersException e)
    {
        return "NoOfPassengersException"+":"+e.getMessage();
    }
//    
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ResponseInfo> handlerMethodForException(Exception ex,HttpServletRequest request)
//    {
//        String message=ex.getMessage();
//        ResponseInfo ri=new ResponseInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),message,request.getRequestURI());
//        ResponseEntity<ResponseInfo> re=new ResponseEntity<>(ri,HttpStatus.NOT_FOUND);
//        return re;
//    }
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

