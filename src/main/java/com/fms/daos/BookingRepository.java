package com.fms.daos;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Booking;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, BigInteger>{
	
}
