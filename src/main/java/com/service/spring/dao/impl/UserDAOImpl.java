package com.service.spring.dao.impl;

import com.service.spring.dao.UserDAO;
import com.service.spring.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.user.mapper.";
    @Override
    public User getUser(String userEmail) {
        return sqlSession.selectOne(NS+"getUser", userEmail);
    }
}
