package com.fms.services;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.dtos.Airport;
import com.fms.dtos.Schedule;
import com.fms.dtos.ScheduledFlight;
import com.fms.exceptions.RecordAlreadyPresentException;
import com.fms.exceptions.RecordNotFoundException;
import com.fms.exceptions.ScheduledFlightNotFoundException;
import com.fms.daos.AirportDao;
import com.fms.daos.ScheduleDao;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleDao scheduleDao;

	
	@Override
	public Iterable<Schedule> viewAllSchedule() {
		return scheduleDao.findAll();
	}

	@Override
	public Schedule viewSchedule(BigInteger scheduleId) {
		Optional<Schedule> findById = scheduleDao.findById(scheduleId);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("SceduleId not found: " + scheduleId + "not exists");
	    }
	
	@Override
	public ResponseEntity<?> addSchedule(Schedule schedule) {
		Optional<Schedule> findById = scheduleDao.findById(schedule.getScheduleId());
		try {
		if (!findById.isPresent()) {
			scheduleDao.save(schedule);
			return new ResponseEntity<Schedule>(schedule,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Schedule with ID : " + schedule.getScheduleId() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Schedule>(schedule,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Schedule modifyschedule (Schedule schedule) {
		Optional<Schedule> findById = scheduleDao.findById(schedule.getScheduleId());
		if (findById.isPresent()) {
			scheduleDao.save(schedule);
		} 
		else
			throw new RecordNotFoundException("Schedule with code: " + schedule.getScheduleId() + " not exists");
		return schedule;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeSchedule(BigInteger scheduleId) {
		Optional<Schedule> findById = scheduleDao.findById(scheduleId);
		if (findById.isPresent()) {
			scheduleDao.deleteById(scheduleId);
			return "Schedule removed";
		} else
			throw new RecordNotFoundException("Schedule with code: " + scheduleId + " not exists");

	}
}
