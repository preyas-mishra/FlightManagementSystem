package com.fms.daos;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Airport;

@Repository("airportRepository")
public interface AirportDao extends JpaRepository<Airport, Integer>{
	
	public List<Airport> findByAirportCode(String airportCode);
	
}
