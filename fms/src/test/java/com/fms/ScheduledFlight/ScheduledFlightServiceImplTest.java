package com.fms.ScheduledFlight;

import com.fms.dtos.Airport;
import com.fms.dtos.Flight;
import com.fms.dtos.Schedule;
import com.fms.dtos.ScheduledFlight;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ScheduledFlightServiceImplTest {

    @Test()
    public final void testEquals() throws NullPointerException {
        Airport airport1= new Airport("A101","Spain","Spain Airport");
        Airport airport2= new Airport("A102","India","IGI Airport");
        Flight flight= new Flight(new BigInteger("101"),"C101","M101",200);
        Schedule schedule= new Schedule(new BigInteger("1"),airport1,airport2, LocalDateTime.of(2020,6,12,13,50),LocalDateTime.of(2020,6,13,10,20));
        ScheduledFlight sFlight1 = new ScheduledFlight();
        assertNotNull(sFlight1);
        ScheduledFlight sFlight2 = null;
        ScheduledFlight sFlight3= new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
        ScheduledFlight sFlight4= new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
        assertEquals(sFlight3, sFlight4);
        assertNotEquals(sFlight3, sFlight2);
        //  assertEquals(sFlight2.hashCode(), sFlight3.hashCode());
    }


    @Test
    public final void testToString() {
        Airport airport1= new Airport("A101","Spain","Spain Airport");
        Airport airport2= new Airport("A102","India","IGI Airport");
        Flight flight= new Flight(new BigInteger("101"),"C101","M101",200);
        Schedule schedule= new Schedule(new BigInteger("1"),airport1,airport2, LocalDateTime.of(2020,06,12,13,50),LocalDateTime.of(2020,06,13,10,20));
        ScheduledFlight sFlight1= new ScheduledFlight(new BigInteger("101"),flight,120,schedule);
        String result = String.format("ScheduledFlight [scheduleFlightId=%3s, flight=%15s, availableSeats=%3s, schedule=%20s]",
                sFlight1.getScheduleFlightId(), sFlight1.getFlight(),
                sFlight1.getAvailableSeats(), sFlight1.getSchedule());
        assertEquals(result, sFlight1.toString());
    }

    @Test
    public final void testScheduledFlight() {
        Airport airport1= new Airport("A101","Spain","Spain Airport");
        Airport airport2= new Airport("A102","India","IGI Airport");
        BigInteger b1= new BigInteger("101");
        Flight flight= new Flight(b1,"C101","M101",200);
        Schedule schedule= new Schedule(new BigInteger("1"),airport1,airport2, LocalDateTime.of(2020,06,12,13,50),LocalDateTime.of(2020,06,13,10,20));
        ScheduledFlight sFlight1= new ScheduledFlight(b1,flight,120,schedule);
        assertEquals(b1, sFlight1.getScheduleFlightId());
        assertEquals(120, sFlight1.getAvailableSeats());
        assertEquals(flight, sFlight1.getFlight());
        assertEquals(schedule, sFlight1.getSchedule());
    }
}