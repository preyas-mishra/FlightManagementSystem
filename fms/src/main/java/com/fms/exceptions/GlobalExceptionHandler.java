package com.fms.exceptions;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the global exception handler class that gets involked by the springdata
 * when there occurs an exception at any point of application
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserIdNotFoundException.class)
    public String handlerForIdNotFoundException(UserIdNotFoundException e)
    {
        return "IdNotFoundException :"+e.getMessage();
    }

    @ExceptionHandler(UserIdAlreadyExistException.class)
    public String handlerForIdAlreadyExistException(UserIdAlreadyExistException e)
    {
        return "IdAlreadyExistException :"+e.getMessage();
    }

    @ExceptionHandler(AdminUserCannotBeDeletedException.class)
    public String handlerForAdminUserCannotBeDeletedException(AdminUserCannotBeDeletedException e)
    {
        return "AdminUserCannotBeDeletedException :"+e.getMessage();
    }

    @ExceptionHandler(BookingAlreadyPresentException.class)
    public String handlerForBookingAlreadyPresentException(BookingAlreadyPresentException e) {
        return "BookingAlreadyPresentException :" +e.getMessage();
    }

    @ExceptionHandler(BookingIdNotFoundException.class)
    public String handlerForBookingIdNotFoundException(BookingIdNotFoundException e)
    {
        return "IdNotFoundException"+":"+e.getMessage();
    }

    @ExceptionHandler(PassengerIdNotFoundException.class)
    public String handlingMethod(PassengerIdNotFoundException e) {
        return "IdNotFoundException"+":"+e.getMessage();
    }

    @ExceptionHandler(NoOfPassengersException.class)
    public String handlerForNoPassengerException(NoOfPassengersException e)
    {
        return "NoOfPassengersException"+":"+e.getMessage();
    }

    @ExceptionHandler(AirportIdNotFoundException.class)
    public String handlingMethod(AirportIdNotFoundException e)
    {
        return "Id Not Found Exception"+":"+e.getMessage();
    }

    @ExceptionHandler(ScheduleIdNotFoundException.class)
    public String handlerForIdNotFoundException(ScheduleIdNotFoundException e)
    {
        return "Schedule Id Not Found Exception :"+e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handlerForMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        Map<String,String> errorMessage=new LinkedHashMap<>();
        List<ObjectError> list=e.getAllErrors();
        list.forEach(obj->{
            FieldError fieldError=(FieldError)obj;
            String fieldName=fieldError.getField();
            String message=fieldError.getDefaultMessage();
            errorMessage.put(fieldName, message);
        });
        return errorMessage;
    }


}
