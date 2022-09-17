package com.fms.dtos;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger bookingId;
	
	@FutureOrPresent
	private LocalDate bookingDate;
//	private List<Passenger>passengerList;
//	private Flight flight;
	
	@OneToOne
	private User user;
	
	
	@Min(value = 1, message = "No of Passengers should be in range of 1-4")
	@Max(value = 4, message = "No of Passengers should be in range of 1-4")
	private Integer noOfPassengers;
	
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
