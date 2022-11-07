package com.fms.exceptions;

public class AirportIdAlreadyExistException extends RuntimeException{
	
	public AirportIdAlreadyExistException(String msg)
    {
        super(msg);
    }

}
