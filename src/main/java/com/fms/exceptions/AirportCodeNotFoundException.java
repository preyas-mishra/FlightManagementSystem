package com.fms.exceptions;

public class AirportCodeNotFoundException extends RuntimeException {
	
	private String msg;
	
	public AirportCodeNotFoundException(String msg)
	{
		super(msg);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
