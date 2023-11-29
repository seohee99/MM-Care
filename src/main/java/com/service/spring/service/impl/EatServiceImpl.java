package com.service.spring.service.impl;

import com.service.spring.dao.EatDAO;
import com.service.spring.service.EatService;
import com.service.spring.vo.Eat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EatServiceImpl implements EatService {
    @Autowired
    private EatDAO eatDAO;


    @Override
    public int checkEat(Eat eat) {
        return eatDAO.checkEat(eat);
    }

    @Override
    public int modifyEat(Eat eat) {
        return eatDAO.modifyEat(eat);
    }

    @Override
    public int deleteEat(Eat eat) {
        return eatDAO.deleteEat(eat);
    }

    @Override
    public List<Eat> showCheckList(Eat eat) {
        return eatDAO.showCheckList(eat);
    }
}
