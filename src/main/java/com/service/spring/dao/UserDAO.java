package com.service.spring.dao;

import com.service.spring.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    User findUserByKakaoEmail(String email);
    void save(User user);
}
