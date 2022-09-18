package com.fms.services;

import org.springframework.http.ResponseEntity;

import com.fms.dtos.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(Long airportCode);

	public ResponseEntity<?> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(Long airportCode);
}
