package com.fms.daos;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fms.dtos.Airport;

@Repository("airportRepository")
public interface AirportDao extends CrudRepository<Airport, BigInteger> {
	List<Airport>findAll();
}