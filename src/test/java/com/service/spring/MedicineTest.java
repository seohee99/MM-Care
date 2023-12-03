package com.service.spring;

import com.service.spring.dao.MedicineDAO;
import com.service.spring.service.MedicineService;
import com.service.spring.vo.Care;
import com.service.spring.vo.Medicine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class MedicineTest {

    @Autowired
    private MedicineDAO medicineDAO;
    @Autowired
    private MedicineService medicineService;

    @Test
    public void unitTest() throws Exception{
        Medicine medicine = new Medicine();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        medicine.setDate(currentTimestamp);
        medicine.setPetSeq(1);
        medicine.setMedicineType("알약");
        medicine.setMemo("메모 수정합니다.");
        medicine.setCnt(1);
        medicine.setNickname("김유완");

//      항목 추가하고 뜨는지 확인
//        int result = medicineService.checkMedicine(medicine);
//        System.out.println(result);

//        수정되는지 확인
//        int result2 = medicineService.modifyMedicine(medicine);
//        System.out.println(result2);

//        삭제 확인
//        int result = medicineService.deleteMedicine(medicine);
//        System.out.println(result);

//      체크 리스트 전체 조회 테스트
        List<Medicine> medicinelist = medicineService.showCheckList(medicine);
        Care care  = new Medicine();
        for(Medicine medicines : medicinelist){
            System.out.println(medicines);
        }

    }
}
