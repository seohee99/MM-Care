package com.service.spring.vo;

import lombok.Data;

@Data
public class Join {
    private long userSeq;
    private long groupSeq;
    private String joinNickName;
    private int joinActivate;
}
