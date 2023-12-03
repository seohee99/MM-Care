package com.service.spring.dao.impl;

import com.service.spring.dao.CareDAO;
import com.service.spring.vo.Care;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CareDAOImpl implements CareDAO {
    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.care.mapper.";

    @Override
    public int getCheckCnt(Care care) {
        System.out.println("DAOImpl... getCheckCnt() 진입 성공...");

        int cnt = 0;
        if(care.getCareType().equals("eat")){
            System.out.println("CARE_EAT 진입 전...");
            Optional<Integer> optional = Optional.ofNullable(sqlSession.selectOne(NS+"getEatCheckCnt", care));
            cnt = optional.orElse(0);
            System.out.println("CARE_EAT 에서 가져온 cnt: " + cnt);
        }else if(care.getCareType().equals("walk")){
            System.out.println("CARE_WALK 진입 전..." + care.getDate());
            Optional<Integer> optional = Optional.ofNullable(sqlSession.selectOne(NS+"getWalkCheckCnt", care));
            cnt = optional.orElse(0);
            System.out.println("CARE_WALK 에서 가져온 cnt: " + cnt);
        }else if(care.getCareType().equals("poop")) {
            System.out.println("CARE_POOP 진입 전...");
            Optional<Integer> optional = Optional.ofNullable(sqlSession.selectOne(NS+"getPoopCheckCnt", care));
            cnt = optional.orElse(0);
            System.out.println("CARE_POOP 에서 가져온 cnt: " + cnt);
        }else if(care.getCareType().equals("medicine")){
            System.out.println("CARE_MEDICINE 진입 전...");
            Optional<Integer> optional = Optional.ofNullable(sqlSession.selectOne(NS+"getMedicineCheckCnt", care));
            cnt = optional.orElse(0);
            System.out.println("CARE_MEDICINE 에서 가져온 cnt: " + cnt);
        }
        return cnt;
    }
}
