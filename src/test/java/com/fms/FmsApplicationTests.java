package com.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.time.LocalDateTime;
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
	
	BigInteger sid1 = BigInteger.valueOf(89098);
	BigInteger sid2 = BigInteger.valueOf(99898);
	BigInteger sid3 = BigInteger.valueOf(43212);
	BigInteger sid4 = BigInteger.valueOf(10734);
	BigInteger sid5 = BigInteger.valueOf(56789);
	BigInteger sid6 = BigInteger.valueOf(63012);
	
	@Autowired
	AirportDao airportRepository;
	
	@Autowired
	private ScheduleDao scheduleRepository;
	
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
	
	
	
	//Schedule
	@Test
	public void testCreateSchedule() {
		Schedule s=new Schedule();
		Airport dstnAirport=new Airport(103,"Indira Gandhi International Airport","New Delhi, Delhi, India","DEL");
		airportRepository.save(dstnAirport);
		Airport srcAirport=new Airport(104,"Rajiv Gandhi International Airport","Shamshabad, Hyderabad, Telangana, India","HYD");
		airportRepository.save(srcAirport);
		s.ScheduleId(sid1);
		s.setDeptDateTime(LocalDateTime.of(2022,12,22,12,23,34));
		s.setArrDateTime(LocalDateTime.of(2022,12,22,15,10,30));
		s.setDstnAirport(dstnAirport);
		s.setSrcAirport(srcAirport);
	}
		
	@Test
	public void testReadAllSchedules() {
		List<Schedule> list=scheduleRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
 @Test
	public void testSingleSchedule() {
		Schedule schedule=scheduleRepository.findById(sid1).get();
		assertEquals("2022,12,22,12,23,34",schedule.getDeptDateTime());
	}
	
 
	@Test
	public void testUpdateSchedule() {
		Schedule s=scheduleRepository.findById(sid1).get();
		s.setDeptDateTime(LocalDateTime.of(2022,12,20,12,22,34));
		scheduleRepository.save(s);
		assertNotEquals("2022,12,20,12,22,34",scheduleRepository.findById(sid1).get().getDeptDateTime());
	}
	 

	@Test
	public void testDeleteSchedule() {
		scheduleRepository.deleteById(sid1);
		assertThat(scheduleRepository.existsById(sid1)).isFalse();
	}

}
