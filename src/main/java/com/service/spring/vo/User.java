package com.service.spring.vo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private long userSeq;
    private String userEmail;
    private String userNickName;
    private String userAddress;
    private String userPhone;
    private String userImg;
    private int userGroupCnt;
    private List<Join> joins;

    private User() {}
}
