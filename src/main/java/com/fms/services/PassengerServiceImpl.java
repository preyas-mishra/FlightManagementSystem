package com.fms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.daos.PassengerDao;
import com.fms.dtos.Passenger;
import com.fms.exceptions.PassengerIdNotFoundException;

@Service("ps")
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	PassengerDao pr;
	
	//save passenger details(insert) (Add)
	@Override
	public ResponseEntity<Passenger> savePassengers(Passenger pas) {
		 pr.save(pas);
		 return new ResponseEntity<>(pas,HttpStatus.CREATED);
	}
	
	//get all passengers details(view)
	@Override
	public List<Passenger> getAllPassengers() {
		return pr.findAll();
	}
	
	//get a passenger details
	@Override
	public Optional<Passenger> getPassengerById(Integer passId) {
		return pr.findById(passId);
	}
	
	//delete the passenger details by their id
	@Override
	public void deletePassengerById(Integer passId) {
		pr.deleteById(passId);
	}
	
	//4 update passenger details
	@Override
	public ResponseEntity<String> updatePassengerDetails(Integer passId,Passenger pas) {
		Optional<Passenger> oPass = pr.findById(passId);
		if(oPass.isPresent()) {
		  Passenger pas1 = oPass.get();
		   if(pas.getGender() != null) {
		   	 pas1.setGender(pas.getGender());
		   }
		   if(pas.getPassengerAge() != null) {
			 pas1.setPassengerAge(pas.getPassengerAge());
		   }
		   if(pas.getPassengerName() != null) {
		     pas1.setPassengerName(pas.getPassengerName());
		   }
		   if(pas.getPassengerUIN() != null) {
		     pas1.setPassengerUIN(pas.getPassengerUIN());
		   }
		   if(pas.getPnrNumber() != null) {
		     pas1.setPnrNumber(pas.getPnrNumber());
		   }
		   pas1.setLuggage(pas.getLuggage());
		  pr.save(pas1);
		  return new ResponseEntity<>("Passenger Details Updated Successfully",HttpStatus.ACCEPTED);
		}
		else {
			throw new PassengerIdNotFoundException("Passenger is not found for id : "+passId);	
		}
			 
	}
}