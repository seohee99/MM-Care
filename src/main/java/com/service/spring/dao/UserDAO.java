package com.service.spring.dao;

import com.service.spring.vo.User;

import java.util.List;

public interface UserDAO {
//    User getUser(String userEmail);
    List<User> getUserByGroupSeq(int groupSeq);
}
