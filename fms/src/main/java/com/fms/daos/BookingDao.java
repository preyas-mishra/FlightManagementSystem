package com.fms.daos;

import com.fms.dtos.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking, BigInteger> {
    @Query("select bookings from User u join u.booking bookings where u.userId=:userId")
    public List<Booking> viewBookingsByUserId(@Param("userId") BigInteger userId);
}