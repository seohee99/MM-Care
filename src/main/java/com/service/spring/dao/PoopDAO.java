package com.service.spring.dao;

import com.service.spring.vo.Poop;

import java.util.List;

public interface PoopDAO {

    int checkPoop (Poop poop);
    int modifyPoop (Poop poop);
    int deletePoop (Poop poop);

    List<Poop> showCheckList (Poop poop);

}
