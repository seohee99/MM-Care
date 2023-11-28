package com.service.spring.vo;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private long groupSeq;
    private String groupName;
    private long groupLeader;
    private String groupMemo;
    private List<Pet> pets;
    private List<Calendar> calendars;
    private List<Join> joins;

    public Group() {}
}
