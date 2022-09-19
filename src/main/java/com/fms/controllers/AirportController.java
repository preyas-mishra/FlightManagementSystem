package com.fms.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dtos.Airport;
import com.fms.exceptions.AirportIdNotFoundException;
import com.fms.services.AirportService;
import com.fms.services.ScheduleServiceImpl;

@RestController
public class AirportController {

	@Autowired
	AirportService airportService ;
	
	@GetMapping("/airports")
	public List<Airport> viewAirports() {
		return airportService.viewAirports();
	}
	
	@GetMapping("/airports/{airportId}")
	@ExceptionHandler(AirportIdNotFoundException.class)
	public Airport viewAirportById(@PathVariable("airportId") Integer airportId) {
		return airportService.viewAirportById(airportId);
	}
	
	@GetMapping("/airports/{airportCode}")
	public List<Airport> findByAirportCode(@PathVariable("airportCode") String airportCode){
		return airportService.findByAirportCode(airportCode);
	}
	
}
