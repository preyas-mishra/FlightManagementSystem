package com.fms.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Airports")
public class Airport {
	
	@NotEmpty(message="airportName cannot be empty")
	public String airportName;
	@NotEmpty(message="airportLocation cannot be empty")
	public String airportLocation;
	@Id
	@NotEmpty(message="airportCode cannot be empty")
	public String airportCode;
	
	
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
	

}
