package com.service.spring.controller;

import com.service.spring.service.CalendarService;
import com.service.spring.vo.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @GetMapping("/calendarTest/group/{userSeq}")
    @ResponseBody
    public List<HashMap<String, Object>> getGroups(@PathVariable long userSeq) {
        return calendarService.getGroups(userSeq);
    }

    @GetMapping("/calendarTest/groupDog/{groupSeq}")
    @ResponseBody
    public List<HashMap<String, Object>> getGroupDogs(@PathVariable long groupSeq) {
        return calendarService.getGroupDogs(groupSeq);
    }

    @PostMapping("/calendar/add")
    @ResponseBody
    public int addPlan(@RequestBody Calendar calendar){
        System.out.println(calendar.toString());
        return calendarService.addPlan(calendar);
    }

    @DeleteMapping("/calendar/delete/{calSeq}")
    @ResponseBody
    public int deletePlan(@PathVariable long calSeq){
        return calendarService.deleteGroupPlan(calSeq);
    }

    @PutMapping("/calendar/update")
    @ResponseBody
    public int updatePlan(@RequestBody Calendar calendar){
        return calendarService.updateGroupPlan(calendar);
    }

    @GetMapping("/calendar/monthly")
    @ResponseBody
    public List<Calendar> getGroupMonthlyPlan(
            @RequestParam(value = "groupSeq") long groupSeq,
            @RequestParam(value = "year") int year,
            @RequestParam(value = "month") int month
    ){
        return calendarService.groupMonthlyPlan(groupSeq, year, month);
    }

    @GetMapping("/calendar/daily")
    @ResponseBody
    public List<Calendar> getGroupDailyPlan(
            @RequestParam(value = "groupSeq") long groupSeq,
            @RequestParam(value = "year") int year,
            @RequestParam(value = "month") int month,
            @RequestParam(value = "day") int day
    ){
        return calendarService.groupDailyPlan(groupSeq, year, month, day);
    }
}
