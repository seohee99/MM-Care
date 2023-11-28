package com.service.spring;

import com.service.spring.dao.EatDAO;
import com.service.spring.service.EatService;
import com.service.spring.vo.Eat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@SpringBootTest
@Transactional
@Commit
public class EatTest {
    @Autowired
    private EatDAO eatDAO;
    @Autowired
    private EatService eatService;

    @Test
    public void unitTest() throws Exception{
        Eat eat = new Eat();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        eat.setDate(currentTimestamp);
        eat.setPetSeq(2);
        eat.setMemo("메모 수정 ㅎㅎ");
        eat.setCnt(2);
        eat.setImg("임시 이미지 주소 수정 ㅎㅎ");
        eat.setNickname("용훈3");

        // 항목 추가 (체크하기) 테스트
        int flag = eatService.checkEat(eat);
        System.out.println("flag: " + flag);

        // 수정 테스트
//        int flag2 = eatService.modifyEat(eat);
//        System.out.println("flag2: " + flag2);

        // 삭제 테스트
//        int flag3 = eatService.deleteEat(eat);
//        System.out.println("flag3: " + flag3);

        // 당일 체크 리스트 전체 조회 테스트
//        List<Eat> eatlist = eatService.showCheckList(eat);
//        Care care  = new Eat();
//        for(Eat eats : eatlist){
//            System.out.println(eats);
//        }
    }
}
