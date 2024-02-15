package com.service.spring.service.impl;

import com.service.spring.dao.CalendarDAO;
import com.service.spring.service.CalendarService;
import com.service.spring.vo.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {
    @Autowired
    private CalendarDAO calendarDAO;

    @Override
    public List<HashMap<String, Object>> getGroups(long userSeq) {
        return calendarDAO.getGroups(userSeq);
    }

    @Override
    public List<HashMap<String, Object>> getGroupDogs(long groupSeq) {
        return calendarDAO.getGroupDogs(groupSeq);
    }

    @Override
    public int addPlan(Calendar calendar) {
        return calendarDAO.addPlan(calendar);
    }

    @Override
    public int deleteGroupPlan(long calSeq) {
        return calendarDAO.deleteGroupPlan(calSeq);
    }

    @Override
    public int updateGroupPlan(Calendar calendar) {
        return calendarDAO.updateGroupPlan(calendar);
    }

    @Override
    public List<Calendar> groupMonthlyPlan(long groupSeq, int year, int month) {
        return calendarDAO.getGroupMonthlyPlan(groupSeq, year, month);
    }

    @Override
    public List<Calendar> groupDailyPlan(long groupSeq, int year, int month, int day) {
        return calendarDAO.getGroupDailyPlan(groupSeq, year, month, day);
    }
}
