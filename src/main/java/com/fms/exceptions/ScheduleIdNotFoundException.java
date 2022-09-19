package com.fms.exceptions;

public class ScheduleIdNotFoundException extends RuntimeException  {
	
private String s;
	
	public ScheduleIdNotFoundException(String s)
	{
		super(s);
	}

}