package com.fms.daos;

import com.fms.dtos.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BookingDao extends JpaRepository<Booking, BigInteger> {
}