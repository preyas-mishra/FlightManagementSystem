package com.fms.controllers;

import java.math.BigInteger;
//import java.util.Optional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.exceptions.RecordNotFoundException;

import com.fms.dtos.Flight;
import com.fms.services.FlightServiceImpl;

//import exceptions.RecordNotFoundException;
//import exceptions.FlightAlreadyExistsExpection;

@RestController
//@RequestMapping("")
public class FlightController {
	@Autowired(required = true)
	FlightServiceImpl flightService;

	@PostMapping("/flights")
	//@ExceptionHandler(FlightAlreadyExistsExpection.class)
	public ResponseEntity<Flight> addFlight(@Valid @RequestBody  Flight flight) {
		flightService.addFlight(flight);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}

	@GetMapping("/flights")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/flights/{id}")
	//@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/flights/{id}")
	public ResponseEntity<String> modifyFlight(@Valid @RequestBody Flight flight, @PathVariable("id") BigInteger flightNo) {
		
		flightService.modifyFlight(flightNo, flight);
		return new ResponseEntity<String>("Data Updated Successfully",HttpStatus.OK);
	}

	@DeleteMapping("/flights/{id}")
	public void removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
	}
	
	
}