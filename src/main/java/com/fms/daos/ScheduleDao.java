package com.fms.daos;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Schedule;

@Repository("scheduleRepository")
public interface ScheduleDao extends CrudRepository<Schedule, BigInteger> {
	List<Schedule>findAll();
}
