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
import com.fms.dtos.Schedule;
import com.fms.services.FlightService;
import com.fms.services.FlightServiceImpl;
import com.fms.services.ScheduleService;


@RestController
public class ScheduleController {
	@Autowired(required = true)
	ScheduleService scheduleService;

	@PostMapping("/schedule")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addSchedule(@RequestBody Schedule schedule) {
		scheduleService.addSchedule(schedule);
	}

	@GetMapping("/schedule")
	public Iterable<Schedule> viewAllSchedule() {
		return scheduleService.viewAllSchedule();
	}

	@GetMapping("/schedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Schedule viewSchedule(@PathVariable("id") BigInteger scheduleId) {
		return scheduleService.viewSchedule(scheduleId);
	}

	@PutMapping("/schedule")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifySchedule(@RequestBody Schedule schedule) {
		scheduleService.modifyschedule(schedule);
	}

	@DeleteMapping("/schedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeSchedule(@PathVariable("id") BigInteger scheduleId) {
		scheduleService.removeSchedule(scheduleId);
	}
}
