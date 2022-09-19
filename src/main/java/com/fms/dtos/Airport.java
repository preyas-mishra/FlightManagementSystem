package com.fms.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Airports")
public class Airport {
	
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Airport(@NotEmpty(message = "airport Id cannot be empty") int airportId,
			@NotEmpty(message = "airport Name cannot be empty") String airportName,
			@NotEmpty(message = "airport Location cannot be empty") String airportLocation,
			@NotEmpty(message = "airportCode cannot be empty") String airportCode) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotEmpty(message="airport Id cannot be empty")
	public int airportId;
	@NotEmpty(message="airport Name cannot be empty")
	public String airportName;
	@NotEmpty(message="airport Location cannot be empty")
	public String airportLocation;
	@NotEmpty(message="airportCode cannot be empty")
	public String airportCode;	
	

	public int getAirportId() {
		return airportId;
	}
	public void setAirportId(int airportId) {
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
	
}
