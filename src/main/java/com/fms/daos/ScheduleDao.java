package com.fms.daos;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Schedule;

@Repository("scheduleRepository")
public interface ScheduleDao extends JpaRepository<Schedule, Integer> {

}
