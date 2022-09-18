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
	//public Airport viewAirport(String airportCode);
	//Optional<Airport> viewAirportByCode(String airportCode);
	
	
	public Airport addAirport(Airport newAirport);
    public Airport updateAirport(Airport updateAirport);
    public void deleteAirport(Integer airportId);
}
