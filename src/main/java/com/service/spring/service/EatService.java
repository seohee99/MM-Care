package com.service.spring.service;

import com.service.spring.vo.Eat;

import java.util.List;

public interface EatService {

    int checkEat (Eat eat);
    int modifyEat (Eat eat);
    int deleteEat (Eat eat);
    List<Eat> showCheckList (Eat eat);
}
