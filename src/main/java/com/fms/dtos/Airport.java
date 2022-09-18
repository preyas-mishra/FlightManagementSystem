package com.fms.dtos;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Airport

{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long airportId;
	private String airportCode;
	private String airportLocation;
	private String airportName;

	public Airport(String airportName, String airportLocation, String airportCode)
	/**
	 * parameterized Constructor
	 */
	{
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

	public Airport()
	/**
	 * Unparameterized Constructor
	 */
	{
	}

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {
		return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '}';
	}
}
