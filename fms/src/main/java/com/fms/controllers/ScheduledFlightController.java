package com.fms.controllers;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fms.dtos.Schedule;
import com.fms.dtos.ScheduledFlight;
import com.fms.exceptions.RecordNotFoundException;
import com.fms.exceptions.ScheduledFlightNotFoundException;
import com.fms.services.AirportService;
import com.fms.services.FlightService;
import com.fms.services.ScheduledFlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ScheduledFlightController {
	
	@Autowired
	ScheduledFlightService scheduleFlightService;

	@Autowired
	AirportService airportService;

	@Autowired
	FlightService flightService;
	@PostMapping("/scheduledflights")
	public ResponseEntity<ScheduledFlight> addSF(@RequestBody ScheduledFlight scheduledFlight)
//			@ModelAttribute ScheduledFlight scheduledFlight,
//			@RequestParam(name = "srcAirport") String source,
//			@RequestParam(name = "dstnAirport") String destination,
//			@RequestParam(name = "deptDateTime") String departureTime,
//			@RequestParam(name = "arrDateTime") String arrivalTime 
	{		
		
		scheduleFlightService.addScheduledFlight(scheduledFlight);
		return new ResponseEntity<ScheduledFlight>(scheduledFlight,HttpStatus.OK);
		//		Schedule schedule = new Schedule();
//		schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
//		try {
//			schedule.setSrcAirport(airportService.viewAirport(source));
//		} catch (RecordNotFoundException e) {
//			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
//		}
//		try {	
//			schedule.setDstnAirport(airportService.viewAirport(destination));
//		} catch (RecordNotFoundException e) {
//			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
//		}
//		schedule.setDeptDateTime(departureTime);
//		schedule.setArrDateTime(arrivalTime);
//		try {
//			scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
//		} catch (RecordNotFoundException e1) {
//			return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
//		}
//		scheduledFlight.setSchedule(schedule);
//		scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
//		try {
//			return new ResponseEntity<ScheduledFlight>(scheduleFlightService.addScheduledFlight(scheduledFlight),HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
//		}
	}

	
	@PutMapping("/scheduledflights")
	public ResponseEntity<ScheduledFlight> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) 
	{
		ScheduledFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		if (modifySFlight == null)
		{
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<ScheduledFlight>(modifySFlight, HttpStatus.OK);
		}

	}

	@DeleteMapping("/scheduledflights/{flightId}")
	public String deleteSF(@PathVariable BigInteger flightId) throws RecordNotFoundException
	{
		return scheduleFlightService.removeScheduledFlight(flightId);
	}

	@GetMapping("/scheduledflights/{flightId}")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<ScheduledFlight> viewSF(@PathVariable BigInteger flightId) throws ScheduledFlightNotFoundException {
		ScheduledFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
		if (searchSFlight == null) {
			return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ScheduledFlight>(searchSFlight, HttpStatus.OK);
		}
	}
	
	@GetMapping("/scheduledflights")
	public Iterable<ScheduledFlight> viewAllSF() {
		return scheduleFlightService.viewAllScheduledFlights();
	}
	

}
