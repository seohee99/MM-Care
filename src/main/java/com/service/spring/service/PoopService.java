package com.service.spring.service;

import com.service.spring.vo.Poop;

import java.util.List;

public interface PoopService {

    int checkPoop (Poop poop);
    int modifyPoop (Poop poop);
    int deletePoop (Poop poop);
    List<Poop> showCheckList (Poop poop);
}
