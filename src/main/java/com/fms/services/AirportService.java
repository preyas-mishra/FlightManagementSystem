package com.fms.services;

import java.util.List;

import com.fms.dtos.Airport;

public interface AirportService {
	//read
	public List<Airport> viewAirports();
	//view by airportCode
	public Airport viewAirport(String airportCode);
}
