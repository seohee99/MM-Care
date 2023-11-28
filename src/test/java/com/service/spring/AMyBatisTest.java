package com.service.spring;

import com.service.spring.dao.UserDAO;
import com.service.spring.dao.UserGroupDAO;
import com.service.spring.vo.Group;
import com.service.spring.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class AMyBatisTest {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserGroupDAO userGroupDAO;

    @Test
    public void unitTest() throws Exception{
        User user = userDAO.getUser("example@example.com");
        System.out.println(user.toString());

        List<Group> groups = userGroupDAO.getUserGroup();
        for(Group g:groups){
            System.out.println(g);
        }
    }
}
