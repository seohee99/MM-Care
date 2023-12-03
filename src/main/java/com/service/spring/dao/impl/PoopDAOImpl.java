package com.service.spring.dao.impl;

import com.service.spring.dao.PoopDAO;
import com.service.spring.vo.Poop;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PoopDAOImpl implements PoopDAO {

    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.poop.mapper.";

    @Override
    public int checkPoop(Poop poop) {
        int result = sqlSession.insert(NS+"checkPoop" , poop);
        return result;

    }
    @Override
    public int modifyPoop (Poop poop) {
        int result = sqlSession.update(NS+"updatePoop" , poop);
        return result;

    }
    @Override
    public int deletePoop(Poop poop) {
        int result = sqlSession.delete(NS+"deletePoop" , poop) ;
        return result;
    }

    @Override
    public List<Poop> showCheckList(Poop poop) {
        List<Poop> poopList = new ArrayList<>();
        if(sqlSession.selectList(NS + "showAll", poop) != null) {
            poopList = sqlSession.selectList(NS + "showAll", poop);
        }
        return poopList;
    }

}


