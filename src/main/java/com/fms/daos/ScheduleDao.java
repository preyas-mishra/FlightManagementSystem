package com.fms.daos;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Schedule;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, BigInteger> {

}
