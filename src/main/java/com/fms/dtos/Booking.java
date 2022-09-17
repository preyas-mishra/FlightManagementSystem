package com.fms.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger bookingId;

    @FutureOrPresent
    private LocalDate bookingDate;
//	private List<Passenger>passengerList;
//	private Flight flight;

    @Min(value = 1, message = "No of Passengers should be in range of 1-4")
    @Max(value = 4, message = "No of Passengers should be in range of 1-4")
    private Integer noOfPassengers;

    @JsonIgnore
    @ManyToOne
//    @OneToOne
    @JoinColumn(name="user_id")
//    @NotEmpty(message = "User id in bookings cannot be null so cannot create booking")
    private User user;

    public BigInteger getBookingId() {
        return bookingId;
    }
    public void setBookingId(BigInteger bookingId) {
        this.bookingId = bookingId;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public Integer getNoOfPassengers() {
        return noOfPassengers;
    }
    public void setNoOfPassengers(Integer noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Booking()
    {}

    public Booking(BigInteger bookingId, LocalDate bookingDate, Integer noOfPassengers,User user) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.noOfPassengers = noOfPassengers;
        this.user = user;
    }
}
