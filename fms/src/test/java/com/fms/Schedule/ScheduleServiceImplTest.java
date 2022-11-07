package com.fms.Schedule;

import com.fms.daos.AirportDao;
import com.fms.daos.ScheduleDao;
import com.fms.dtos.Airport;
import com.fms.dtos.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleServiceImplTest {


    BigInteger sid1 = BigInteger.valueOf(5);
    BigInteger sid2 = BigInteger.valueOf(99898);
    BigInteger sid3 = BigInteger.valueOf(43212);
    BigInteger sid4 = BigInteger.valueOf(10734);
    BigInteger sid5 = BigInteger.valueOf(56789);
    BigInteger sid6 = BigInteger.valueOf(63012);

    @Autowired
    private ScheduleDao scheduleRepository;

    @Autowired
    AirportDao airportRepository;

    @Test
    public void testCreateSchedule() {
        Airport dstnAirport=new Airport(3,"Indira Gandhi International Airport","New Delhi, Delhi, India","DEL");
        airportRepository.save(dstnAirport);
        Airport srcAirport=new Airport(4,"Rajiv Gandhi International Airport","Shamshabad, Hyderabad, Telangana, India","HYD");
        airportRepository.save(srcAirport);
        Schedule s=new Schedule(sid1,srcAirport,dstnAirport,LocalDateTime.of(2022,12,22,12,23,34),LocalDateTime.of(2022,12,22,15,10,30));
        scheduleRepository.save(s);
        Schedule schedule=scheduleRepository.findById(sid1).get();
        assertNotNull(schedule,"Schedule Created Successfully");
    }

    @Test
    public void testReadAllSchedules() {
        List<Schedule> list= (List<Schedule>) scheduleRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void testSingleSchedule() {
        Airport dstnAirport=new Airport(103,"Indira Gandhi International Airport","New Delhi, Delhi, India","DEL");
        airportRepository.save(dstnAirport);
        Airport srcAirport=new Airport(104,"Rajiv Gandhi International Airport","Shamshabad, Hyderabad, Telangana, India","HYD");
        airportRepository.save(srcAirport);
        Schedule s=new Schedule(sid1,srcAirport,dstnAirport,LocalDateTime.of(2022,12,22,12,23,34),LocalDateTime.of(2022,12,22,15,10,30));
        scheduleRepository.save(s);
        Schedule schedule=scheduleRepository.findById(sid1).get();
        assertEquals(LocalDateTime.of(2022,12,22,12,23,34),schedule.getDeptDateTime());
    }


    @Test
    public void testUpdateSchedule() {
        Airport dstnAirport=new Airport(103,"Indira Gandhi International Airport","New Delhi, Delhi, India","DEL");
        airportRepository.save(dstnAirport);
        Airport srcAirport=new Airport(104,"Rajiv Gandhi International Airport","Shamshabad, Hyderabad, Telangana, India","HYD");
        airportRepository.save(srcAirport);
        Schedule s=new Schedule(sid1,srcAirport,dstnAirport,LocalDateTime.of(2022,12,22,12,23,34),LocalDateTime.of(2022,12,22,15,10,30));
        scheduleRepository.save(s);
        Schedule s1=new Schedule(sid1,srcAirport,dstnAirport,LocalDateTime.of(2022,12,23,17,10,00),LocalDateTime.of(2022,12,22,15,10,30));
        scheduleRepository.save(s1);
        assertEquals(LocalDateTime.of(2022,12,23,17,10,00),scheduleRepository.findById(sid1).get().getDeptDateTime());
    }


    @Test
    public void testDeleteSchedule() {
        Airport dstnAirport=new Airport(103,"Indira Gandhi International Airport","New Delhi, Delhi, India","DEL");
        airportRepository.save(dstnAirport);
        Airport srcAirport=new Airport(104,"Rajiv Gandhi International Airport","Shamshabad, Hyderabad, Telangana, India","HYD");
        airportRepository.save(srcAirport);
        Schedule s=new Schedule(sid1,srcAirport,dstnAirport,LocalDateTime.of(2022,12,22,12,23,34),LocalDateTime.of(2022,12,22,15,10,30));
        scheduleRepository.save(s);
        scheduleRepository.deleteById(sid1);
        assertThat(scheduleRepository.existsById(sid1)).isFalse();
    }

}