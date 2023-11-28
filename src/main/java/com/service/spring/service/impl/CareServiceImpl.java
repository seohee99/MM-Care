package com.service.spring.service.impl;

import com.service.spring.dao.CareDAO;
import com.service.spring.service.CareService;
import com.service.spring.vo.Care;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CareServiceImpl implements CareService {
    @Autowired
    private CareDAO careDAO;
    @Override
    public int getCheckCnt(Care care) {
        return careDAO.getCheckCnt(care);
    }
}
