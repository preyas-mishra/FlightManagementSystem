package com.fms.exceptions;

public class BookingAlreadyPresentException extends RuntimeException{
	public BookingAlreadyPresentException(String message){
		super(message);
	}
}
