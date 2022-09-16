package com.fms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dtos.Airport;
import com.fms.exceptions.AirportCodeNotFoundException;
import com.fms.services.AirportService;

@RestController
public class AirportController {

	@Autowired
	AirportService se ;
	
	@GetMapping("/airports")
	public List<Airport> viewAirports() {
		return se.viewAirports();
	}
	
	@GetMapping("/airports/{code}")
	@ExceptionHandler(AirportCodeNotFoundException.class)
	public Airport viewAirport(@PathVariable("code") String airportCode) {
		return se.viewAirport(airportCode);
	}
}
