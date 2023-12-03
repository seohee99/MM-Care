package com.service.spring.service.impl;

import com.service.spring.dao.MedicineDAO;
import com.service.spring.service.MedicineService;
import com.service.spring.vo.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDAO medicineDAO;
    @Override
    public int checkMedicine(Medicine medicine) {
        return medicineDAO.checkMedicine(medicine)  ;
    }

    @Override
    public int modifyMedicine(Medicine medicine) {
        return medicineDAO.modifyMedicine(medicine);
    }

    @Override
    public int deleteMedicine(Medicine medicine) {
        return medicineDAO.deleteMedicine(medicine);
    }

    @Override
    public List<Medicine> showCheckList(Medicine medicine) {
        return medicineDAO.showCheckList(medicine);
    }
}
