package com.service.spring.dao;

import com.service.spring.vo.User;

public interface UserDAO {
    User getUser(String userEmail);
}
