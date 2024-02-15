package com.service.spring;

import com.service.spring.dao.CalendarDAO;
import com.service.spring.dao.UserDAO;
import com.service.spring.dao.UserGroupDAO;
import com.service.spring.vo.Calendar;
import com.service.spring.vo.Group;
import com.service.spring.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class CalendarTest {

    @Autowired
    private CalendarDAO calendarDAO;

    @Test
    public void unitTest() throws Exception{
        getGroupsTest();

        getGroupDogsTest();

//        addPlanTest();

        getGroupMonthlyPlanTest();

        getGroupDailyPlanTest();

        deleteGroupPlanTest();

//        updateGroupPlanTest();
    }



    public void getGroupsTest(){
        List<HashMap<String, Object>> groups = calendarDAO.getGroups(1);
        for(int i=0; i< groups.size(); i++){
            System.out.println(groups.get(i));
        }
    }

    public void getGroupDogsTest(){
        List<HashMap<String, Object>> groupDogs = calendarDAO.getGroupDogs(1);
        for(int i=0; i< groupDogs.size(); i++){
            System.out.println(groupDogs.get(i));
        }
    }

    public void addPlanTest(){
        int result = calendarDAO.addPlan(new Calendar(0,1,2,Timestamp.valueOf("2023-11-29 00:00:00"),Timestamp.valueOf("2023-11-30 00:00:00"),"멍뭉 미용","멍뭉미용실에서 멍뭉 미용하기",""));
        System.out.println(result);
    }

    public void getGroupMonthlyPlanTest(){
//        String currentTimestampToString = "2023/01/01 00:00:00";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        dateFormat.setLenient(false);// 날짜와 시간을 엄격하게 확인
//        Date stringToDate = dateFormat.parse(currentTimestampToString);
//        Timestamp stringToTimestamp = new Timestamp(stringToDate.getTime());
//
//        System.out.println(stringToDate.);
        List<Calendar> monthlyPlan = calendarDAO.getGroupMonthlyPlan(1, 2023, 1);
        for(Calendar c:monthlyPlan){
            System.out.println(c.toString());
        }
    }

    public void getGroupDailyPlanTest(){
        List<Calendar> dailyPlan = calendarDAO.getGroupDailyPlan(1, 2023, 11, 29); // new DateVO(2023, 11,29)
        for(Calendar c:dailyPlan){
            System.out.println(c.toString());
        }
    }

    public void deleteGroupPlanTest(){
        int result = calendarDAO.deleteGroupPlan(3);
        System.out.println(result);
    }

    public void updateGroupPlanTest(){
        int result = calendarDAO.updateGroupPlan(new Calendar(3,2,1,Timestamp.valueOf("2023-11-29 00:00:00"),Timestamp.valueOf("2023-11-30 10:00:00"),"멍뭉 병원", "멍뭉병원에 멍뭉 진료", "N"));
        System.out.println(result);
    }
}
