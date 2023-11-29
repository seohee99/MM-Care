package com.service.spring.service;

import com.service.spring.vo.User;


public interface UserService {
    User save(String token);
    User findUserByKakaoEmail(String email);
}
