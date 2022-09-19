package com.fms.services;

import java.math.BigInteger;
import java.util.List;

import com.fms.dtos.Passenger;
import org.springframework.http.ResponseEntity;

import com.fms.dtos.Booking;

public interface BookingService {
	
	public Booking addBooking(Booking booking);
	
	public Booking modifyBooking(Booking booking);
	
	public Booking viewBooking(BigInteger bid);
	
	public List<Booking>viewBooking();
	
	public void deleteBooking(BigInteger bid);
	
	
}
