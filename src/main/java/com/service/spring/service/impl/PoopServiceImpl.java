package com.service.spring.service.impl;

import com.service.spring.dao.PoopDAO;
import com.service.spring.service.PoopService;
import com.service.spring.vo.Poop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoopServiceImpl implements PoopService {

    @Autowired
    private PoopDAO poopDAO;

    @Override
    public int checkPoop(Poop poop) {
        return poopDAO.checkPoop(poop);
    }

    @Override
    public int modifyPoop(Poop poop) {
        return poopDAO.modifyPoop(poop);
    }

    @Override
    public int deletePoop(Poop poop) {
        return poopDAO.deletePoop(poop);
    }

    @Override
    public List<Poop> showCheckList(Poop poop) {
        return poopDAO.showCheckList(poop);
    }
}
