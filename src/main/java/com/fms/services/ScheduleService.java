package com.fms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.fms.dtos.Schedule;
import com.fms.exceptions.RecordAlreadyPresentException;
import com.fms.repositories.ScheduleRepository;

@Service
public class ScheduleService {
	@Autowired
    ScheduleRepository scheduleRepository;
  
	public ResponseEntity<?> createSchedule(Schedule schedule) {
		Optional<Schedule> findScheduleById = scheduleRepository.findById(schedule.getScheduleId());
		try {
			if (!findScheduleById.isPresent()) {
				scheduleRepository.save(schedule);
				return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Schedule with Id: " + schedule.getScheduleId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
