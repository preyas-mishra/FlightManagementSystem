package com.fms.dtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer passId;
	
	@Min(value = 1000000000L) 
	@Max(value = 9999999999L)
	private Long pnrNumber;
	
	@NotEmpty(message = "The passengerName should not be blank.")
	private String passengerName;
	
	@NotNull(message = "The passengerAge should not be null.")
	private Integer passengerAge;
	
	@NotEmpty(message = "The gender field must not be blank.")
	private String gender;
	
	@Min(value = 100000000000L) 
	@Max(value = 999999999999L)
	private Long passengerUIN;
	
	@Min(value=1) @Max(value=25)
	private double luggage;
	
    
    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

	
	public Integer getPassId() {
		return passId;
	}

	//as id is auto increment so no need of setpassid
	
	public Long getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(Long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(Long passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}
	

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}


}