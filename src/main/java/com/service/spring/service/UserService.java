package com.service.spring.service;

import com.service.spring.vo.User;

import java.util.List;

public interface UserService {

    User getUser(String userEmail);
    List<User> getUserByGroupSeq(int groupSeq);
}
