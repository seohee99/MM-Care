package com.service.spring;

import com.service.spring.dao.mapper.UserMapper;
import com.service.spring.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
public class UserMyBatisTest {

    @Autowired
    private UserMapper userMapper;

    @DisplayName("find by kakao email Test")
    @Test
    public void testFindByKakaoEmail(){
        String actual = "example@example.com";
        User user = userMapper.findUser(
                User.builder()
                    .userEmail(actual)
                    .build());
        log.info(user.toString());
        Assertions.assertTrue(actual.equals(user.getUserEmail()));
    }

    @DisplayName("save user Test")
    @Test
    @Commit
    public void testSaveUser(){
        User user = User.builder()
                .userEmail("example@test.com")
                .userNickName("testName")
                .build();
        userMapper.save(user);
    }

}
