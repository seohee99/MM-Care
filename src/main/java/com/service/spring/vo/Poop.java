package com.service.spring.vo;

import lombok.Data;

@Data
public class Poop extends Care{
    private long poopSeq;
    private int poopCnt;
    private int peeCnt;

    public Poop() {}
}
