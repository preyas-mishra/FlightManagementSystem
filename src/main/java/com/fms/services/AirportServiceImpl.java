package com.fms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.daos.AirportDao;
import com.fms.dtos.Airport;
//import com.fms.exceptions.AirportIdAlreadyExistException;
import com.fms.exceptions.AirportIdNotFoundException;

@Transactional
@Service("airportService")
public class AirportServiceImpl implements AirportService {

	@Autowired
	private AirportDao airportRepository;

	@Override
	public List<Airport> viewAirports()
	{
		return airportRepository.findAll();
	}
		
	@Override
	public Airport viewAirportById(Integer airportId)
	{
		Optional<Airport> findById = airportRepository.findById(airportId);
		if (findById.isPresent()) {
			return findById.get();
		}			
		else
		{
			throw new AirportIdNotFoundException("Airport not found with airport id: " + airportId);
	    }
	}
	
	@Override
	public List<Airport> findByAirportCode(String airportCode){
		List<Airport> airports=airportRepository.findByAirportCode("HYD");
		airports.forEach(e->System.out.println(e));	
		return airports;
	}
	
	 
}
