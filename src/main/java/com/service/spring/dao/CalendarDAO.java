package com.service.spring.dao;

import com.service.spring.vo.Calendar;
import com.service.spring.vo.DateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface CalendarDAO {
    //그룹 가져오기 (개인 아이디/고유번호로 찾기)
    List<HashMap<String, Object>> getGroups(long userSeq);

    //그룹 내 강아지 가져오기 (그룹 아이디로 가져오기)
    List<HashMap<String, Object>> getGroupDogs(long groupSeq);

    //일정 추가하기 (서비스에서 유효성 검사 / 시작~종료 범위체크)
    //hashmap = long groupSeq, Calendar calendar
    int addPlan(Calendar calendar);

    //일정 가져오기(월별)
    List<Calendar> getGroupMonthlyPlan(long groupSeq, int year, int month);

    //일정 가져오기(일별)
    List<Calendar> getGroupDailyPlan(long groupSeq, int year, int month, int day); // DateVO date

    //일정 삭제하기
    int deleteGroupPlan(long calSeq);

    //일정 수정하기
    int updateGroupPlan(Calendar calendar);
}
