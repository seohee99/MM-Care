package com.service.spring.dao.impl;

import com.service.spring.dao.CareDAO;
import com.service.spring.vo.Care;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
            if(sqlSession.selectOne(NS+"getEatCheckCnt", care) != null) {
                cnt = sqlSession.selectOne(NS + "getEatCheckCnt", care);
            }
            System.out.println("CARE_EAT 에서 가져온 cnt: " + cnt);
        }else if(care.getCareType().equals("walk")){
            System.out.println("CARE_WALK 진입 전..." + care.getDate());
            if(sqlSession.selectOne(NS+"getWalkCheckCnt", care) != null) {
                cnt = sqlSession.selectOne(NS + "getWalkCheckCnt", care);
            }
            System.out.println("CARE_WALK 에서 가져온 cnt: " + cnt);
        }else if(care.getCareType().equals("poop")) {
            System.out.println("CARE_POOP 진입 전...");
            if(sqlSession.selectOne(NS+"getPoopCheckCnt", care) != null) {
                cnt = sqlSession.selectOne(NS + "getPoopCheckCnt", care);
            }
            System.out.println("CARE_POOP 에서 가져온 cnt: " + cnt);
        }else if(care.getCareType().equals("medicine")){
            System.out.println("CARE_MEDICINE 진입 전...");
            if(sqlSession.selectOne(NS+"getMedicineCheckCnt", care) != null) {
                cnt = sqlSession.selectOne(NS + "getMedicineCheckCnt", care);
            }
            System.out.println("CARE_MEDICINE 에서 가져온 cnt: " + cnt);
        }
        return cnt;
    }
}
