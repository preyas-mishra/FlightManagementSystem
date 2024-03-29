package com.fms.daos;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fms.dtos.Booking;
import com.fms.dtos.User;

@Repository("bookingRepository")
public interface BookingDao extends JpaRepository<Booking, BigInteger>{
	@Query("select bookings from User u join u.booking bookings where u.userId = :userId")
	List<Booking>findBookingsByUserId(@Param("userId")BigInteger userId);
}
