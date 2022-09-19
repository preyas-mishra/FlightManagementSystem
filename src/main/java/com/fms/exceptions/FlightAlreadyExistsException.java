package com.fms.exceptions;

public class FlightAlreadyExistsException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FlightAlreadyExistsException(String message) {
        super(message);
        
    }
   
}

