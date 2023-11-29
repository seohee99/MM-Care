package com.service.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Join {
    private long userSeq;
    private long groupSeq;
    private String joinNickName;
    private int joinActivate;
}
