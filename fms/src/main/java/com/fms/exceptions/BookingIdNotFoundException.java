package com.fms.exceptions;

public class BookingIdNotFoundException extends RuntimeException {
	public BookingIdNotFoundException(String message){
		super(message);
	}
}
