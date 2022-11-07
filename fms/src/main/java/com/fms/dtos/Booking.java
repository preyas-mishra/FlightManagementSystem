package com.fms.dtos;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger bookingId;

    @FutureOrPresent
    private LocalDate bookingDate;

    @Min(value = 1, message = "No of Passengers should be in range of 1-4")
    @Max(value = 4, message = "No of Passengers should be in range of 1-4")
    private Integer noOfPassengers;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Valid
    private List<Passenger> passengerList = new ArrayList<>();

    @OneToOne
    @Valid
    ScheduledFlight scheduledFlight;

    Double ticketCost;

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

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList)
    {
        this.passengerList = passengerList;
        for(Passenger temp:passengerList) {
            temp.setBooking(this);
        }
    }

    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(ScheduledFlight scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
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
