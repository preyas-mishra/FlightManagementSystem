package com.fms.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Airport;

@Repository("re")
public interface AirportDao extends JpaRepository<Airport, String>{

}
