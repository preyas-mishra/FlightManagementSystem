package com.fms.services;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.fms.dtos.Flight;

public interface FlightService {
	public Flight addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public Flight modifyFlight(Flight flight);

	public String removeFlight(BigInteger flightNumber);

}
