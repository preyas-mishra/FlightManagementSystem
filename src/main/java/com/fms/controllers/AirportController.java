package com.fms.controllers;

import java.math.BigInteger;
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
	
	/*@Autowired
    ScheduleServiceImpl scheduleService;*/
	
	@GetMapping("/airports")
	public List<Airport> viewAirports() {
		return airportService.viewAirports();
	}
	
	@GetMapping("/airports/{airportId}")
	@ExceptionHandler(AirportIdNotFoundException.class)
	public Airport viewAirportById(@PathVariable("airportId") BigInteger airportId) {
		return airportService.viewAirportById(airportId);
	}
	
/*
	@PostMapping("/airports")
    public ResponseEntity<Airport> addAirport(@Valid @RequestBody Airport newAirport)
    {
		Airport airport=airportService.addAirport(newAirport);
        return new ResponseEntity<>(airport,HttpStatus.CREATED);
    }
	
    @PutMapping("/airports")
    public ResponseEntity<Airport> updateAirport(@Valid @RequestBody Airport updateAirport)
    {
    	Airport airport=airportService.updateAirport(updateAirport);
        return new ResponseEntity<>(airport,HttpStatus.OK);
    }
    @DeleteMapping("/airports/{airportId}")
	public ResponseEntity<String> deleteAirport(@PathVariable("airportId") Integer airportId) {
    	airportService.deleteAirport(airportId);
		return new ResponseEntity<String>("Airport Deleted Successfully with Id"+airportId,HttpStatus.OK);
	}
	*/
}