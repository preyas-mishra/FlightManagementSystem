package com.fms.services;

import java.math.BigInteger;
import java.util.List;

import com.fms.dtos.Schedule;

public interface ScheduleService {

	//create
	public Schedule addSchedule(Schedule schedule);
	//read
	public List<Schedule> viewSchedules();
	//update
	public Schedule modifySchedule(Schedule schedule);
	//delete
	public void deleteSchedule(BigInteger scheduleId);
	//viewById
	public Schedule viewSchedule(BigInteger scheduleId);
}