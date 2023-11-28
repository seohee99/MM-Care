package com.service.spring.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public abstract class Care {
    private long petSeq;
    private int cnt;
    private String nickname;
    private String img;
    private Timestamp date;
    private String memo;
    private String careType;

    public Care() {}

}
