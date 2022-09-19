package com.fms.services;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.daos.FlightDao;
import com.fms.dtos.Flight;
import com.fms.exceptions.FlightAlreadyExistsException;
import com.fms.exceptions.RecordNotFoundException;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightDao flightRepo;
	
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightRepo.findAll();
	}
	
	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		 //flightRepo.findById(flightNumber);
		Optional<Flight> fFlight=flightRepo.findById(flightNumber);
		if(fFlight.isPresent()) {
			return fFlight.get();
		}
		else {
		throw new RecordNotFoundException("Flight with id:"+flightNumber+"does not exists");
	    }
	}
	
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightRepo.findById(flight.getFlightNo());
		if (!findById.isPresent()) {
			flightRepo.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.CREATED);
		}
		else {
			throw new FlightAlreadyExistsException("Flight already exists");
		}
		//flightRepo.save(flight);
		//return new ResponseEntity<Flight>(flight,HttpStatus.CREATED);
	}
	
	@Override
	public  ResponseEntity<String> modifyFlight(BigInteger flightNumber,Flight flight) {
		Optional<Flight> findById = flightRepo.findById(flightNumber);
		if (findById.isPresent()) {
			Flight prevFlight=findById.get();
			if(flight.getCarrierName()!=null) {
				prevFlight.setCarrierName(flight.getCarrierName());
			}
			if(flight.getFlightModel()!=null) {
				prevFlight.setFlightModel(flight.getCarrierName());
			}
			
			flightRepo.save(flight);
			return new ResponseEntity<String>("Data updated successfully",HttpStatus.ACCEPTED);
		} 
		else {
			throw new RecordNotFoundException("Flight no"+flightNumber+" is not found ");
		}
		//return flight;
	}
	
	@Override
	public String removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepo.findById(flightNumber);
		if (findById.isPresent()) {
			flightRepo.deleteById(flightNumber);
			return "Flight removed!!";
			
		} else
			throw new RecordNotFoundException("Flight No"+ flightNumber+"does not exists");

	}

	
	
	
	
	

}
