package com.fms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dtos.Passenger;
import com.fms.exceptions.PassengerIdNotFoundException;
import com.fms.services.PassengerServiceImpl;

@RestController
public class PassengerController {

	@Autowired
	PassengerServiceImpl ps;
	
	//1. insert passenger details
	@PostMapping("/passengers")
	public ResponseEntity<Passenger> addPassenger(@Valid @RequestBody Passenger passenger) {
		ps.savePassengers(passenger);
		return new ResponseEntity<>(passenger,HttpStatus.OK);
	}
	
	//2. get all passenger details
	@GetMapping("/passengers")
	public List<Passenger> viewPassengers() {
		return ps.getAllPassengers();
	}
	
	//3. Get passenger details by their id
	@GetMapping("/passengers/{id}")
	public Passenger viewPassengerById(@PathVariable("id") Integer passId) {
		Optional<Passenger> oPass = ps.getPassengerById(passId);
		if(oPass.isPresent())
			return oPass.get();
		else
			throw new PassengerIdNotFoundException("Passenger is not found for id : "+passId);
	}
	
	//4. delete passenger details by their id
	@DeleteMapping("/passengers/{id}")
	public void deletePassengerById(@PathVariable("id") Integer passId) {
		Optional<Passenger> oPass = ps.getPassengerById(passId);
		if(oPass.isPresent())
			ps.deletePassengerById(passId);
		else
			throw new PassengerIdNotFoundException("Passenger is not found for id : "+passId);	
	}
	
	//5. update passenger details by their id
	@PutMapping("/passengers/{id}")
	public ResponseEntity<String> updatePassengerDetails( @PathVariable("id") Integer passId,@Valid @RequestBody Passenger passenger) {
		ps.updatePassengerDetails(passId, passenger);
		return new ResponseEntity<>("Passenger details updated successfully",HttpStatus.OK);
	}
	
}
