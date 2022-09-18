package com.fms.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fms.dtos.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, Long> {

}