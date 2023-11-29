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
public abstract class Care {
    private long petSeq;
    private int cnt;
    private String nickname;
    private String img;
    private Timestamp date;
    private String memo;
    private String careType;


}
