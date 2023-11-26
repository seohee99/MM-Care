package com.service.spring.dao.impl;

import com.service.spring.dao.UserGroupDAO;
import com.service.spring.vo.Group;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserGroupDAOImpl implements UserGroupDAO {
    @Autowired
    private SqlSession sqlSession;
    public static final String NS = "sql.usergroup.mapper.";

    @Override
    public List<Group> getUserGroup() {
        return sqlSession.selectList(NS+"getGroup");
    }
}
