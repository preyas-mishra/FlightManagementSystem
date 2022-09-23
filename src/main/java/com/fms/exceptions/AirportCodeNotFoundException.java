package com.fms.exceptions;

public class AirportCodeNotFoundException extends RuntimeException {
	
	private String msg;
	
	public AirportCodeNotFoundException(String msg)
	{
		super(msg);
	}

}
