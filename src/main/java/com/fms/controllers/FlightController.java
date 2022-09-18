package com.fms.controllers;

import java.math.BigInteger;

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
import com.fms.dtos.Flight;
import com.fms.services.FlightService;
import com.fms.services.FlightServiceImpl;


@RestController
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/flight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
	}

	@GetMapping("/flight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/flight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/flight")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
	}

	@DeleteMapping("/flight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
	}
}
