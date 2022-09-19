package com.fms.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dtos.Booking;
import com.fms.dtos.User;
import com.fms.services.BookingServiceImpl;
import com.fms.services.UserServiceImpl;

@RestController
public class BookingController {
	
		@Autowired
		private BookingServiceImpl bookingService;
		
		@Autowired 
		private UserServiceImpl userService;
		
		private List<Booking>bookingList;
		
		
		@PostMapping("/bookingsbyuser/{userId}")
		public ResponseEntity<User> addBookingByUserId(@Valid @RequestBody Booking booking,@PathVariable("userId") BigInteger userId){
			User user = userService.viewUser(userId);
			List<Booking>bookingList1 = user.getBooking();
			booking.setUser(user);
			booking.setTicketCost(300.00);
			bookingList1.add(booking);
			user.setBooking(bookingList1);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		
		@PostMapping("/bookings")
		public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
		//		Creates a new booking.
			Booking booking1=bookingService.addBooking(booking);
			return new ResponseEntity<>(booking1,HttpStatus.OK);
		}
		
//		Modifies a previous booking. All information related to the 
//		booking except the booking id can be modified.
		@PutMapping("/bookings")
		public ResponseEntity<Booking> modifyBooking(@Valid @RequestBody Booking booking) {
			Booking booking1=bookingService.modifyBooking(booking);
			return new ResponseEntity<>(booking1,HttpStatus.OK);
		}
		
		@GetMapping("/bookings/{bid}")
		public Booking viewBooking(@PathVariable("bid") BigInteger bid){
//		Retrieves a booking made
//		by the user based on the booking id.
			
			return bookingService.viewBooking(bid);
		}
		
		@GetMapping("/bookings")
		public List<Booking>viewBooking(){
//		Retrieves a list of all the bookings made.
			return bookingService.viewBooking();
		}
		
		@DeleteMapping("/bookings/{bid}")
		public ResponseEntity<String> deleteBooking(@PathVariable("bid") BigInteger bid) {
//		Deletes a previous booking identifiable by the ‘bookingId’.
			bookingService.deleteBooking(bid);
			return new ResponseEntity<String>("Record Deleted Successfully with Id"+bid,HttpStatus.OK);
		}
}
