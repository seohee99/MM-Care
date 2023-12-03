package com.service.spring.dao.impl;

import com.service.spring.dao.MedicineDAO;
import com.service.spring.vo.Medicine;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicineDAOImpl implements MedicineDAO {

    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.medicine.mapper.";
    @Override
    public int checkMedicine(Medicine medicine) {
        int result = sqlSession.insert(NS+"checkMedicine" , medicine);
        return result;
    }

    @Override
    public int modifyMedicine(Medicine medicine) {
        int result = sqlSession.update(NS+"updateMedicine" , medicine);
        return result;
    }

    @Override
    public int deleteMedicine(Medicine medicine) {
        int result = sqlSession.delete(NS+"deleteMedicine" , medicine) ;
        return result;
    }

    @Override
    public List<Medicine> showCheckList(Medicine medicine) {
        List<Medicine> medicineList = new ArrayList<>();
        if(sqlSession.selectList(NS + "showAll", medicine) != null) {
            medicineList = sqlSession.selectList(NS + "showAll", medicine);
        }
        return medicineList;
    }
}
