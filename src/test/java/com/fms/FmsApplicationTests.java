package com.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.daos.AirportDao;
import com.fms.dtos.Airport;
import com.fms.daos.ScheduleDao;
import com.fms.dtos.Schedule;

@SpringBootTest
class FmsApplicationTests {
	
	@Autowired
	AirportDao airportRepository;

	/*
	@Test
	void contextLoads() {
	}
	*/
	
	
	//Airport
	@Test
	public void testCreateAirport() {
		Airport a=new Airport();
		a.setAirportId(107);
		a.setAirportName("Dabolim Airport");
		a.setAirportLocation("Airport Rd, Dabolim, Goa 403801");
		a.setAirportCode("GOI");
		airportRepository.save(a);
		assertNotNull(airportRepository.findById(107).get());
	}
	
	@Test
	public void testReadAllAirports() {
		List<Airport> list=airportRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testSingleAirport() {
		Airport airport=airportRepository.findById(107).get();
		assertEquals("GOI",airport.getAirportCode());
	}
	
	@Test
	public void testUpdateAirport() {
		Airport a=airportRepository.findById(107).get();
		a.setAirportLocation("Airport Rd, Dabolim, Goa, India, 403801");
		airportRepository.save(a);
		assertNotEquals("Airport Rd, Dabolim, Goa, India, 403801",airportRepository.findById(107).get().getAirportLocation());
	}
	
	@Test
	public void testDeleteAirport() {
		airportRepository.deleteById(107);
		assertThat(airportRepository.existsById(107)).isFalse();
	}
	
	
	/*
	//Schedule
	@Test
	public void testCreateSchedule() {
		Schedule s=new Schedule();
		s.ScheduleId(12345);
		s.setDeptDateTime(2022-12-22 12:23:34);
		s.setArrDateTime(2022-12-22 15:10:30);
		s.setDstnAirport(null);
		s.setSrcAirport(null);
	}
	
	@Test
	public void testReadAllSchedules() {
		List<Schedule> list=scheduleRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	*/

}
