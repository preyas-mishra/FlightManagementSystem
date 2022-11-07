package com.fms.controllers;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fms.dtos.Booking;
import com.fms.services.BookingServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookingController {
	
		@Autowired
		private BookingServiceImpl bookingService;
		
		private List<Booking>bookingList;
		
		
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

		@GetMapping("/bookings/user/{uid}")
		public List<Booking> viewBookingByUserId(@PathVariable("uid") BigInteger uid)
		{
			return bookingService.viewBookingByUserId(uid);
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