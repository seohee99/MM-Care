package com.service.spring.service.impl;

import com.service.spring.dao.UserDAO;
import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(String userEmail) {
        return userDAO.getUser(userEmail);
    }

    @Override
    public List<User> getUserByGroupSeq(int groupSeq) {
        return userDAO.getUserByGroupSeq(groupSeq);
    }
}
