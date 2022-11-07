package com.fms.Flight;

import com.fms.daos.FlightDao;
import com.fms.dtos.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlightServiceImplTest {

    @Autowired
    FlightDao flightRepo;

    @Test
    public void testAddFlight() {
        Flight flight=new Flight();
        flight.setFlightNo(BigInteger.valueOf(9L));
        flight.setFlightModel("Boeing ");
        flight.setCarrierName("Emirates");
        flight.setSeatCapacity(368);
        flightRepo.save(flight);
        assertNotNull(flightRepo.findById(BigInteger.valueOf(9L)).get());
    }

	@Test
	public void testViewAllFlight() {
		List<Flight> list= (List<Flight>) flightRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}


    @Test
    public void testModifyFlight() {
        Flight flight=flightRepo.findById(BigInteger.valueOf(9L)).get();
        flight.setSeatCapacity(390);
        Flight flightModified=flightRepo.save(flight);

        assertEquals(390,flightModified.getSeatCapacity());
    }

    @Test
    public void testDelete() {
		/*Flight flight=flightRepo.findById(BigInteger.valueOf(9L)).get();
		flightRepo.delete(flight);
		Flight deleteFlight=flightRepo.findById(BigInteger.valueOf(9L)).get();

		assertNotNull(deleteFlight);*/
        boolean flightbefore=flightRepo.findById(BigInteger.valueOf(9L)).isPresent();
        flightRepo.deleteById(BigInteger.valueOf(9L));
        boolean flightafter=flightRepo.findById(BigInteger.valueOf(9L)).isPresent();

        assertTrue(flightbefore);
        assertFalse(flightafter);


    }

    @Test
    public void testViewFlight() {
        Flight flight=flightRepo.findById(BigInteger.valueOf(9L)).get();
        assertEquals("Emirates",flight.getCarrierName());
    }
}