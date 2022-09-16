package com.fms.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Schedule;


@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, BigInteger> {

}
