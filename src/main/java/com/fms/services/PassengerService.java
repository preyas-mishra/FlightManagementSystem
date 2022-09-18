package com.fms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.fms.dtos.Passenger;

public interface PassengerService {

	public ResponseEntity<Passenger> savePassengers(Passenger pas);
	public List<Passenger> getAllPassengers();
	public Optional<Passenger> getPassengerById(Integer passId);
	public void deletePassengerById(Integer passId);
	public ResponseEntity<String> updatePassengerDetails(Integer passId,Passenger pas);
}