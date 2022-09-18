package com.fms.exceptions;

public class AirportIdNotFoundException extends RuntimeException {
	
	private String msg;
	
	public AirportIdNotFoundException(String msg)
	{
		super(msg);
	}

}
