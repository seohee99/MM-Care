package com.service.spring.vo;

import lombok.Data;

@Data
public class Medicine extends Care{
    private long medicineSeq;
    private String medicineType;

    public Medicine() {}
}
