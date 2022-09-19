package com.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.daos.AirportDao;
import com.fms.daos.BookingDao;
import com.fms.daos.FlightDao;
import com.fms.daos.UserDao;
import com.fms.dtos.Airport;
import com.fms.dtos.Booking;
import com.fms.dtos.Flight;
import com.fms.dtos.User;
import com.fms.services.BookingServiceImpl;
import com.fms.services.UserServiceImpl;

@SpringBootTest
class FmsApplicationTests {


	BigInteger bi1=BigInteger.valueOf(8);
	BigInteger bi2 =BigInteger.valueOf(9989801327L);
	BigInteger bi3 = BigInteger.valueOf(4);
	BigInteger bi4 = BigInteger.valueOf(107);
	BigInteger bi5 = BigInteger.valueOf(105);
	BigInteger bi6 = BigInteger.valueOf(102);
	
	@Autowired
	FlightDao flightRepo;

	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AirportDao airportRepository;
	
	@Autowired
	BookingServiceImpl bookingService; 
	
	@Autowired
	UserServiceImpl userService;

	@Test
	public void testViewAllUsersWithAssertThatAssertion()
	{
		List<User> user=userService.viewUser();
		assertThat(user).size().isGreaterThan(6);
	}

	@Test
	public void testViewUserByIdEqualsAssertion()
	{
		User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");

		userService.addUser(user1);

		User user=userService.viewUser(bi1);
		assertEquals(bi2,user.getUserPhone());
	}

	@Test
	public void testCreateUserWithNotNullAssertion()
	{
		User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");

		userService.addUser(user1);

		User user=userService.viewUser(bi1);
		assertNotNull(user,"User Inserted Successfully");
	}

	@Test
	public void testUpdateUserWithNotEqualsAssertion()
	{
		User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");
		User user2=new User("Gorsa Jayaram", bi2,"veerachari@gmail.com","Jayaram","customer");
		user2.setUserId(bi1);
		userService.addUser(user1);
		userService.updateUser(user2);

		User user=userService.viewUser(bi1);
		assertNotEquals("Jayaram",user.getUserName());
	}

	@Test
	public void testDeleteUserByIdWithNotNullAssertion(){
		User user1=new User("Jayaram", bi2,"jayaram.gorsa@gmail.com","Jayaram","customer");

		userService.addUser(user1);
		userService.deleteUser(bi1);

		assertThat(userDao.existsById(bi1)).isFalse();
	}
	
	@Test
	public void testViewAllBookingsWithAssertThatAssertion() {
		List<Booking> booking = bookingService.viewBooking();
		assertThat(booking).size().isGreaterThan(2);
	}
	
	
	
	@Test
	public void testAddBooking() {
		Booking booking = new Booking();
		User user = new User("Preyas",bi2,"preyasmishra@gmail.com","Preyas","customer");  
		userDao.save(user);
		booking.setBookingDate(LocalDate.now());
		booking.setBookingId(bi1);
		booking.setNoOfPassengers(4);
		booking.setUser(user);
		bookingService.addBooking(booking);
		assertNotNull(bookingDao.findById(bi1), "Booking added Successfully");
	}
	
	
	@Test
	public void testViewBookingByIdEqualsAssertion() {
		Booking booking = bookingDao.findById(bi4).get();
		assertEquals(3,booking.getNoOfPassengers(),"No Value found");
	}
	
	@Test
	public void testUpdateBookingWithNotEqualsAssertion() {
		User user = userDao.findById(bi6).get();
		Booking booking = new Booking(bi4,LocalDate.of(2022, 12, 12),4,user);
		bookingService.modifyBooking(booking);
		Booking b = bookingDao.findById(bi4).get();
		assertNotEquals(LocalDate.of(2022, 9, 18),b.getBookingDate());
	}
	
	@Test
	public void testDeleteBookingByIdWithNotNullAssertion() {
		bookingService.deleteBooking(bi4);
		assertThat(bookingDao.existsById(bi4)).isFalse();
	}
	
	
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
	
//	@Test
//	public void testViewAllFlight() {
//		List<Flight>list=flightRepo.findAll();
//		assertThat(list).size().isGreaterThan(0);
//		
//	}
	
	
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
	
	
	@Test
	public void testCreateAirport() {
		Airport a=new Airport();
		a.setAirportId(bi4);
		a.setAirportName("Dabolim Airport");
		a.setAirportLocation("Airport Rd, Dabolim, Goa 403801");
		a.setAirportCode("GOI");
		airportRepository.save(a);
		assertNotNull(airportRepository.findById(bi4).get());
	}
	
	@Test
	public void testReadAllAirports() {
		List<Airport> list=airportRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testSingleAirport() {
		Airport airport=airportRepository.findById(bi4).get();
		assertEquals("GOI",airport.getAirportCode());
	}
	
	@Test
	public void testUpdateAirport() {
		Airport a=airportRepository.findById(bi4).get();
		a.setAirportLocation("Airport Rd, Dabolim, Goa, India, 403801");
		airportRepository.save(a);
		assertNotEquals("Airport Rd, Dabolim, Goa, India, 403801",airportRepository.findById(bi4).get().getAirportLocation());
	}
	
	@Test
	public void testDeleteAirport() {
		airportRepository.deleteById(bi4);
		assertThat(airportRepository.existsById(bi4)).isFalse();
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
