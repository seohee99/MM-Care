package com.service.spring.dao;

import com.service.spring.vo.Medicine;


import java.util.List;

public interface MedicineDAO {
    int checkMedicine (Medicine medicine);
    int modifyMedicine (Medicine medicine);
    int deleteMedicine (Medicine medicine);

    List<Medicine> showCheckList (Medicine medicine);

}
