package com.service.spring.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Walk extends Care{
    private long walkSeq;
    private Timestamp walkStartTime;
    private Timestamp walkEndTime;
    private float walkDistance;
    private int walkDefection;
    private int walkUrination;
    private int walkCal;

    public Walk() {}
}
