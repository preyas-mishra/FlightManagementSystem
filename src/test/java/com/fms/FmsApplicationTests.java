package com.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.math.BigInteger;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.daos.BookingDao;
import com.fms.daos.UserDao;
import com.fms.dtos.Booking;
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
	BookingDao bookingDao;
	
	@Autowired
	UserDao userDao;
	
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
}
