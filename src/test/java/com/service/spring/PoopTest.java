package com.service.spring;

import com.service.spring.dao.PoopDAO;
import com.service.spring.service.PoopService;
import com.service.spring.vo.Poop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class PoopTest {

    @Autowired
    private PoopDAO poopDAO;
    @Autowired
    private PoopService poopService;

    @Test
    public void unitTest() throws Exception{
        Poop poop = new Poop();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        poop.setDate(currentTimestamp);
        poop.setPetSeq(3);
        poop.setMemo("멤모입니다.");
        poop.setPoopCnt(2);
        poop.setPeeCnt(6);
        poop.setImg("응아사진");
        poop.setNickname("유완");

//      항목 추가하고 뜨는지 확인
//        int result = poopService.checkPoop(poop);
//        System.out.println(result);

//        수정되는지 확인
//        int result2 = poopService.modifyPoop(poop);
//        System.out.println(result2);

//        삭제 확인
//        int result = poopService.deletePoop(poop);
//        System.out.println(result);

//      체크 리스트 전체 조회 테스트
//        List<Poop> pooplist = poopService.showCheckList(poop);
//        Care care  = new Poop();
//        for(Poop poops : pooplist){
//            System.out.println(poops);
//        }

    }
}
