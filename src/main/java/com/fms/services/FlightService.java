package com.fms.services;

import java.math.BigInteger;
//import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.fms.dtos.Flight;

//import exceptions.FlightAlreadyExistsExpection;
//import exceptions.RecordNotFoundException;
//import exceptions.RecordNotFoundException;

public interface FlightService {
	public ResponseEntity<?> addFlight(Flight flight); 

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public ResponseEntity<String> modifyFlight(BigInteger flightNumber,Flight flight);

	public String removeFlight(BigInteger flightNumber) ;

}
