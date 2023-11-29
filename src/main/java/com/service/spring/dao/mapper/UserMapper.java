package com.service.spring.dao.mapper;

import com.service.spring.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserByKakaoEmail(String email);
    User findUser(User user);
    void save(User user);
}
