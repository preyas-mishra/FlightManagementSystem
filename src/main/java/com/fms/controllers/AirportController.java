package com.fms.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.exceptions.RecordAlreadyPresentException;
import com.fms.exceptions.RecordNotFoundException;
import com.fms.dtos.Airport;
import com.fms.dtos.Flight;
import com.fms.services.AirportService;
import com.fms.services.AirportServiceImpl;
@RestController
public class AirportController {
	@Autowired(required = true)
	AirportService airportService;

	@GetMapping("/airport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("id") Long airportCode) {
		return airportService.viewAirport(airportCode);
	}

	@GetMapping("/airport")
	public Iterable<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}

	@PostMapping("/airport")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
	}

	@PutMapping("/airport")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyAirport(@RequestBody Airport airport) {
		airportService.modifyAirport(airport);
	}

	@DeleteMapping("airport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeAirport(@PathVariable("id") Long airportCode) {
		airportService.removeAirport(airportCode);
	}
}
