package com.service.spring;

import com.service.spring.dao.UserDAO;
import com.service.spring.dao.UserGroupDAO;
import com.service.spring.service.CareService;
import com.service.spring.vo.Care;
import com.service.spring.vo.Walk;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@Transactional
@Commit
public class CareTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CareService careService;
    @Autowired
    private UserGroupDAO userGroupDAO;

    @Test
    public void unitTest() throws Exception{
        String type = "eat";
        Care care = new Walk();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parsedDate = dateFormat.parse("2023-11-26 08:59");
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        System.out.println(timestamp);
        care.setDate(timestamp);
        care.setCareType(type);
        care.setPetSeq(1);

        int cnt = careService.getCheckCnt(care);
        System.out.println( "오늘의 체크 회수: "+cnt+"...");
    }
}
