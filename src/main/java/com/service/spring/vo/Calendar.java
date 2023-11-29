package com.service.spring.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Calendar {
    private long calSeq;
    private long groupSeq;
    private long aniSeq;
    private Timestamp calStartDate;
    private Timestamp calEndDate;
    private String calTitle;
    private String calDetails;
    private String calSpecial;

    public Calendar() {}
}
