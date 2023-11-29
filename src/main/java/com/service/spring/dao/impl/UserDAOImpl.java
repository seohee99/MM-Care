package com.service.spring.dao.impl;

import com.service.spring.dao.UserDAO;
import com.service.spring.dao.mapper.UserMapper;
import com.service.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByKakaoEmail(String email) {
        return userMapper.findUser(
                User.builder()
                        .userEmail(email)
                        .build());
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
