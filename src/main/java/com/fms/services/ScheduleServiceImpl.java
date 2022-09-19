package com.fms.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.fms.daos.AirportDao;
import com.fms.daos.ScheduleDao;
import com.fms.dtos.Airport;
import com.fms.dtos.Schedule;
import com.fms.exceptions.ScheduleIdNotFoundException;

@Transactional
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleRepository;
	
	@Autowired
	private AirportDao airportRepository;
	
	/*@Autowired
	private ScheduledFlightDao scheduledFlightRepository;*/
	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	@Override
	public List<Schedule> viewSchedules()
	{
		return scheduleRepository.findAll();
	}
	
	@Override
	public Schedule modifySchedule(Schedule schedule) {
		Optional<Schedule> oSchedule = scheduleRepository.findById(schedule.getScheduleId());
		if(oSchedule.isPresent()) {			
			Schedule prevSchedule = oSchedule.get();
			if(schedule.getArrDateTime()!=null) {
				prevSchedule.setArrDateTime(schedule.getArrDateTime());
			}
			if(schedule.getDeptDateTime()!=null) {
				prevSchedule.setDeptDateTime(schedule.getDeptDateTime());
			}
			if(schedule.getSrcAirport()!=null) {
				prevSchedule.setSrcAirport(schedule.getSrcAirport());
			}
			if(schedule.getDstnAirport()!=null) {
				prevSchedule.setDstnAirport(schedule.getDstnAirport());
			}			
			return scheduleRepository.save(prevSchedule);
		}
		else {
			throw new ScheduleIdNotFoundException("Schedule Id is not found "+schedule.getScheduleId());
		}		
	}
	
	public void deleteSchedule(BigInteger scheduleId) {
		Optional<Schedule> oSchedule = scheduleRepository.findById(scheduleId);
		if(oSchedule.isPresent()) {
			scheduleRepository.deleteById(scheduleId);;
		}
		else {
			throw new ScheduleIdNotFoundException("Schedule Id is not found "+scheduleId);
		}
	}
	
	public Schedule viewSchedule(BigInteger scheduleId) {
		Optional<Schedule> oSchedule = scheduleRepository.findById(scheduleId);
		if(oSchedule.isPresent()) {
			return oSchedule.get();
		}
		else {
			throw new ScheduleIdNotFoundException("Schedule Id is not found "+scheduleId);
		}
	}
	
}
