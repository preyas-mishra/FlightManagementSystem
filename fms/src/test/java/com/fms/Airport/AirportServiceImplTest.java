package com.fms.Airport;

import com.fms.daos.AirportDao;
import com.fms.daos.ScheduleDao;
import com.fms.dtos.Airport;
import com.fms.dtos.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE_TIME;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AirportServiceImplTest {

    BigInteger sid1 = BigInteger.valueOf(89098);
    BigInteger sid2 = BigInteger.valueOf(99898);
    BigInteger sid3 = BigInteger.valueOf(43212);
    BigInteger sid4 = BigInteger.valueOf(10734);
    BigInteger sid5 = BigInteger.valueOf(56789);
    BigInteger sid6 = BigInteger.valueOf(63012);

    @Autowired
    AirportDao airportRepository;

    @Autowired
    ScheduleDao scheduleDao;

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

}