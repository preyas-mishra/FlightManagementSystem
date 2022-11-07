package com.fms.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.fms.dtos.Flight;
import com.fms.services.FlightService;
import com.fms.services.FlightServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/flights")
//	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {

		Flight flight1= flightService.addFlight(flight);
		return new ResponseEntity<Flight>(flight1, HttpStatus.OK);
	}

	@GetMapping("/flights")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/flights/{id}")
//	@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/flights")
//	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Flight> modifyFlight(@RequestBody Flight flight) {
		Flight flight1= flightService.modifyFlight(flight);
		return new ResponseEntity<>(flight1,HttpStatus.OK);
	}

	@DeleteMapping("/flights/{id}")
//	@ExceptionHandler(RecordNotFoundException.class)
	public void removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
	}
}
