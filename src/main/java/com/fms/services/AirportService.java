package com.fms.services;

import java.util.List;
import java.util.Optional;

import com.fms.dtos.Airport;

public interface AirportService {
	//read
	public List<Airport> viewAirports();
	//view by airport id
	public Airport viewAirportById(Integer airportId);
	//view by airportCode
	public List<Airport> findByAirportCode(String airportCode);
}
