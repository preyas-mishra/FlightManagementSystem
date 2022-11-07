package com.fms.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fms.dtos.Airport;
import com.fms.exceptions.AirportIdNotFoundException;
import com.fms.services.AirportService;
import com.fms.services.ScheduleServiceImpl;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AirportController {

	@Autowired
	AirportService airportService ;
	
	@Autowired
    ScheduleServiceImpl scheduleService;
	
	@GetMapping("/airports")
	public List<Airport> viewAirports() {
		return airportService.viewAirports();
	}
	
	@GetMapping("/airports/{airportId}")
	public Airport viewAirportById(@PathVariable("airportId") Integer airportId) {
		return airportService.viewAirportById(airportId);
	}

	@GetMapping("/airports/airportCode/{airportCode}")
	public Airport viewAirportByCode(@PathVariable("airportCode") String airportCode) {
		return airportService.viewAirportByCode(airportCode);
	}
	@PostMapping("/airports")
    public ResponseEntity<Airport> addAirport(@Valid @RequestBody Airport newAirport)
    {
		Airport airport=airportService.addAirport(newAirport);
        return new ResponseEntity<>(airport, HttpStatus.CREATED);
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
}
