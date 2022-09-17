package com.fms.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.fms.dtos.Booking;
import com.fms.dtos.Passenger;

public interface BookingService {
	
	public ResponseEntity<Booking> addBooking(Booking booking);
	
	public ResponseEntity<String> modifyBooking(BigInteger bid,Booking booking);
	
	public Booking viewBooking(BigInteger bid);
	
	public List<Booking>viewBooking();
	
	public void deleteBooking(BigInteger bid);
	
}
