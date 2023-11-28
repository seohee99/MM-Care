package com.service.spring.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Weight {
    private Timestamp weightDate;
    private long petSeq;
    private long weight;
}
