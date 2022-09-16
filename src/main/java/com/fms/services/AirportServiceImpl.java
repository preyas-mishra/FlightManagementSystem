package com.fms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fms.daos.AirportDao;
import com.fms.dtos.Airport;
import com.fms.exceptions.AirportCodeNotFoundException;

@Transactional
@Service("se")
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportDao re;

	@Override
	public List<Airport> viewAirports()
	{
		return ((JpaRepository<Airport,String>) re).findAll();
	}
		
	@Override
	public Airport viewAirport(String airportCode)
	{
		Optional<Airport> findById = ((CrudRepository<Airport, String>) re).findById(airportCode);
		if (findById.isPresent()) {
			return findById.get();
		}			
		else
		{
			throw new AirportCodeNotFoundException("Airport not found with airport code: " + airportCode);
	    }
	}
	
}
