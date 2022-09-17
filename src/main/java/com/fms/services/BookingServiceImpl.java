package com.fms.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fms.dtos.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.daos.BookingDao;
import com.fms.dtos.Booking;
//import com.fms.dtos.Passenger;
import com.fms.exceptions.BookingIdNotFoundException;

@Transactional
@Service("bookingService")
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDao bookingRepository;
	
	private List<Booking>bookingList;
	
	public Optional<Booking> getById(BigInteger bid){
		return bookingRepository.findById(bid);
	}
	
	public Booking addBooking(Booking booking) {
//		Creates a new booking.
//		Booking booking1=bookingRepository.save(booking);
//		return new ResponseEntity<>(booking1,HttpStatus.CREATED);
		return bookingRepository.save(booking);
	}
	
	public Booking modifyBooking(Booking booking) {
//		Modifies a previous booking. All information related to the booking 
//		except the booking id can be modified.
		Optional<Booking> oBooking = bookingRepository.findById(booking.getBookingId());
		if(oBooking.isPresent()) {
			Booking prevBooking = oBooking.get();
			if(booking.getBookingDate()!=null) {
				prevBooking.setBookingDate(booking.getBookingDate());
			}
			if(booking.getNoOfPassengers()!=null) {
				prevBooking.setNoOfPassengers(booking.getNoOfPassengers());
			}
//			Booking booking1=bookingRepository.save(prevBooking);
//			return new ResponseEntity<Booking>(booking1,HttpStatus.ACCEPTED);
			return bookingRepository.save(prevBooking);
		}
		else {
			throw new BookingIdNotFoundException("Booking Id is not found "+booking.getBookingId());
		}
		
	}


	//	Retrieves a booking made by the user based on the booking id.
	public Booking viewBooking(BigInteger bid){
		Optional<Booking> oBooking = bookingRepository.findById(bid);
		if(oBooking.isPresent()) {
			return oBooking.get();
		}
		else {
			throw new BookingIdNotFoundException("Booking Id is not found "+bid);
		}
	}
	
	
	//	Retrieves a list of all the bookings
	public List<Booking>viewBooking(){

		bookingList = bookingRepository.findAll();
		return bookingList;
	}
	
	public void deleteBooking(BigInteger bid) {
//		Deletes a previous booking identifiable by the ‘bookingId’.
		
		Optional<Booking> oBooking = bookingRepository.findById(bid);
		if(oBooking.isPresent()) {
			bookingRepository.deleteById(bid);;
		}
		else {
			throw new BookingIdNotFoundException("Booking Id is not found "+bid);
		}
	}
	
	public void validateBooking(Booking bid) {
//		Validates the attributes of a booking.
		
	}
	
	public void validatePassenger(Passenger pid) {
//		Validates the attributes of a passenger.
	}
}
