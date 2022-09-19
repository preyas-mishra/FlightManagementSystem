package com.fms.controllers;

import java.math.BigInteger;
import java.util.List;

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

import com.fms.dtos.Schedule;
import com.fms.services.AirportServiceImpl;
import com.fms.services.ScheduleService;

@RestController
public class ScheduleController {

	@Autowired
    ScheduleService scheduleService;
	
	@Autowired
	AirportServiceImpl airportService ;
	
	@PostMapping("/schedules")
	public ResponseEntity<Schedule> addSchedule(@Valid @RequestBody Schedule schedule) {
		Schedule schedule1=scheduleService.addSchedule(schedule);
		return new ResponseEntity<>(schedule1,HttpStatus.OK);
	}
	
	@GetMapping("/schedules")
	public List<Schedule> viewSchedules() {
		return scheduleService.viewSchedules();
	}
	
	@PutMapping("/schedules")
	public ResponseEntity<Schedule> modifySchedule(@Valid @RequestBody Schedule schedule) {
		Schedule schedule1=scheduleService.modifySchedule(schedule);
		return new ResponseEntity<>(schedule1,HttpStatus.OK);
	}
	
	@DeleteMapping("/schedules/{scheduleId}")
	public ResponseEntity<String> deleteSchedule(@PathVariable("scheduleId") BigInteger scheduleId) {
		scheduleService.deleteSchedule(scheduleId);
		return new ResponseEntity<String>("Record Deleted Successfully with Id"+scheduleId,HttpStatus.OK);
	}
	
	@GetMapping("/schedules/{scheduleId}")
	public Schedule viewSchedule(@PathVariable("scheduleId") BigInteger scheduleId){
		return scheduleService.viewSchedule(scheduleId);
	}

}