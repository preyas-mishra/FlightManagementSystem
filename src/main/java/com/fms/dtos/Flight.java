package com.fms.dtos;

import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flight_no")
	private BigInteger flightNo;
	@NotEmpty(message = "Please provide Flight Name")
	private String flightModel;
	@NotEmpty(message = "Please provide carrier name")
	private String carrierName;
	@Min(10)
	@Max(900)
	private int seatCapacity;
	
	@JsonIgnore
	@OneToOne(mappedBy="flight",cascade = CascadeType.ALL)
	private ScheduledFlight scheduledFlight;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}


	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}


	
	
	
	public BigInteger getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(BigInteger flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}


	public Flight(BigInteger flightNo, String flightModel, String carrierName, int seatCapacity,com.fms.dtos.ScheduledFlight scheduleFlight) {
		super();
		this.flightNo = flightNo;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
		this.scheduledFlight= scheduleFlight;
	}


	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrierName, flightModel, flightNo, scheduledFlight, seatCapacity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(carrierName, other.carrierName) && Objects.equals(flightModel, other.flightModel)
				&& Objects.equals(flightNo, other.flightNo) && Objects.equals(scheduledFlight, other.scheduledFlight)
				&& seatCapacity == other.seatCapacity;
	}
	
	
		

}
