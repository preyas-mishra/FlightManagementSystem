package com.fms.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.ScheduledFlight;

@Repository("scheduledFlightRepository")
public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, Integer> {

}
