package com.service.spring.service;

import com.service.spring.vo.Calendar;

import java.util.HashMap;
import java.util.List;

public interface CalendarService {
    List<HashMap<String, Object>> getGroups(long userSeq);
    List<HashMap<String, Object>> getGroupDogs(long groupSeq);
    int addPlan(Calendar calendar);
    int deleteGroupPlan(long calSeq);
    int updateGroupPlan(Calendar calendar);
    List<Calendar> groupMonthlyPlan(long groupSeq, int year, int month);
    List<Calendar> groupDailyPlan(long groupSeq, int year, int month, int day);
}
