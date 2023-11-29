package com.service.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Walk extends Care{
    private long walkSeq;
    private Timestamp walkStartTime;
    private Timestamp walkEndTime;
    private float walkDistance;
    private int walkDefection;
    private int walkUrination;
    private int walkCal;
}
