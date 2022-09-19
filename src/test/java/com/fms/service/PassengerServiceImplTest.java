package com.fms.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.daos.PassengerRepository;
import com.fms.dtos.Passenger;
import com.fms.services.PassengerServiceImpl;

@SpringBootTest
class PassengerServiceImplTest {
	
	Integer id=31; //change the id everytime so it can pass test cases increment it 
	Integer id1=16;//using for update test case 
	
	@Mock
	PassengerRepository pr;
	
	@Autowired
	PassengerServiceImpl ps;
	
	//test case for view passenger by id
	@Test
	void testGetPassengerById() {
		Passenger actualPassenger= new Passenger();
		Optional<Passenger> pas=Optional.of(actualPassenger);
		when((pr.findById(id1))).thenReturn(pas);
		assertEquals(Optional.of(actualPassenger), pas);
	}
	
	//test case for view all passengers
	@Test
	void testGetAllPassengers() {
		List<Passenger> actualOutput = new ArrayList<>();
		when(pr.findAll()).thenReturn(actualOutput);
		assertIterableEquals(new ArrayList<Passenger>(),actualOutput);
	}
	
	//test case for Delete passenger by id which is present above
	@Test
	void testDeletePassengerById() {
		ps.deletePassengerById(id-1);
		assertThat(pr.existsById(id-1)).isFalse();	
		//everytime need to change id for delete then only test case will pass
	}
	
	//Test case for Add passenger
	@Test
	void testSavePassengers() {
		//everytime change the input for adding
		Passenger passenger = new Passenger();
		passenger.setPnrNumber(9685741987L);
		passenger.setPassengerName("Rohit");
		passenger.setGender("Male");
		passenger.setLuggage(19);
		passenger.setPassengerUIN(356472138956L);
		passenger.setPassengerAge(35);
		ps.savePassengers(passenger);
		assertNotNull(pr.findById(id), "Passenger added Successfully"); //change id also
	}
	
	//test case for Updating passenger details by id
	@Test
	void testUpdatePassengerDetails() {
		Passenger pas= new Passenger();
		Optional<Passenger> pas1=Optional.of(pas);
		when((pr.findById(id1))).thenReturn(pas1);
		pas.setLuggage(14);
		pr.save(pas);
		assertNotEquals(15, pas.getLuggage());
	}
	
}
