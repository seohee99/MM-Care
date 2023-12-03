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
public class Calendar {
    private long calSeq;
    private long groupSeq;
    private long aniSeq;
    private Timestamp calStartDate;
    private Timestamp calEndDate;
    private String calTitle;
    private String calDetails;
    private String calSpecial;

}
