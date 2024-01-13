package com.service.spring.dao.impl;

import com.service.spring.dao.CalendarDAO;
import com.service.spring.mapper.CalendarMapper;
import com.service.spring.vo.Calendar;
import com.service.spring.vo.DateVO;
import com.service.spring.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class CalendarDAOImpl implements CalendarDAO {
    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.calendar.mapper.";
    @Override
    public List<HashMap<String, Object>> getGroups(long userSeq) {
        return sqlSession.selectList(NS+"getGroups", userSeq);
    }

    @Override
    public List<HashMap<String, Object>> getGroupDogs(long groupSeq) {
        return sqlSession.selectList(NS+"getGroupDogs", groupSeq);
    }

    @Override
    public int addPlan(Calendar calendar) {
        return sqlSession.insert(NS+"addPlan", calendar);
    }

    @Override
    public List<Calendar> getGroupMonthlyPlan(long groupSeq, int year, int month) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("groupSeq", groupSeq);
        map.put("date", year+"-"+month+"-"+"01");
        System.out.println(map);

        return sqlSession.selectList(NS+"getGroupMonthlyPlan", map);
    }

    @Override
    public List<Calendar> getGroupDailyPlan(long groupSeq, int year, int month, int day) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("groupSeq", groupSeq);
        map.put("date", year+"-"+month+"-"+day);
        System.out.println(map);

        return sqlSession.selectList(NS+"getGroupDailyPlan", map);
    }

    @Override
    public int deleteGroupPlan(long calSeq) {
        return sqlSession.delete(NS+"deleteGroupPlan", calSeq);
    }

    @Override
    public int updateGroupPlan(Calendar calendar) {
        return sqlSession.update(NS+"updateGroupPlan", calendar);
    }
}
