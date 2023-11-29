package com.service.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private long groupSeq;
    private String groupName;
    private long groupLeader;
    private String groupMemo;
    private List<Pet> pets;
    private List<Calendar> calendars;
    private List<Join> joins;
}
