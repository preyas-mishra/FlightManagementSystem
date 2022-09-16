package com.fms.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fms.dtos.Schedule;
import com.fms.exceptions.RecordAlreadyPresentException;
import com.fms.services.ScheduleService;


@RestController
public class ScheduleController {

	@Autowired
    ScheduleService scheduleService;
    
    @PostMapping("/schedules")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addSchedule(@RequestBody Schedule schedule)
    {
         scheduleService.createSchedule(schedule);
    }
}
