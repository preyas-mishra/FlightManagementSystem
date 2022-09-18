package com.fms.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Airport;

@Repository("airportRepository")
public interface AirportDao extends JpaRepository<Airport, Integer>{

	Optional<Airport> viewAirportByCode(String airportCode);
	
}
