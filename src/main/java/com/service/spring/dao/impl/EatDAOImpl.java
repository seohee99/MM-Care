package com.service.spring.dao.impl;

import com.service.spring.dao.EatDAO;
import com.service.spring.vo.Eat;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EatDAOImpl implements EatDAO {
    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.eat.mapper.";


    @Override
    public int checkEat(Eat eat) {
        int flag = 0;
        if(sqlSession.insert(NS + "checkEat",eat) == 1){
            flag = 1;
        }
        System.out.println("flag: " + flag);
        return flag;
    }

    @Override
    public int modifyEat(Eat eat) {
        int flag = 0;
        if(sqlSession.update(NS+"updateEat", eat) == 1){
            flag = 1;
        }
        return flag;
    }

    @Override
    public int deleteEat(Eat eat) {
        int flag = 0;
        if(sqlSession.delete(NS+"deleteEat", eat) == 1){
            flag = 1;
        }
        return flag;
    }

    @Override
    public List<Eat> showCheckList(Eat eat) {
        List<Eat> careList = new ArrayList<>();
        if(sqlSession.selectList(NS + "showAll", eat) != null) {
            careList = sqlSession.selectList(NS + "showAll", eat);
        }
        return careList;
    }
}
