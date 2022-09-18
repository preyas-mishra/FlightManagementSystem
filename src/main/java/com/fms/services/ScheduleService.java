package com.fms.services;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.fms.dtos.Airport;
import com.fms.dtos.Flight;
import com.fms.dtos.Schedule;
import com.fms.dtos.ScheduledFlight;
import com.fms.exceptions.ScheduledFlightNotFoundException;


public interface ScheduleService {
	public Iterable<Schedule> viewAllSchedule();

	public ResponseEntity<?> addSchedule(Schedule schedule);

	Schedule viewSchedule(BigInteger scheduleId);

	Schedule modifyschedule(Schedule schedule);

	String removeSchedule(BigInteger scheduleId);

}
