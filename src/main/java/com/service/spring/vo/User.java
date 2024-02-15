package com.service.spring.vo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private long userSeq; // user_seq
    private String userEmail; // user_email
    private String userNickName; // user_nickname
    private String userAddress; // user_address
    private String userPhone; // user_phone
    private String userImg; // user_img
    private int userGroupCnt; // user_group_cnt
    private List<Join> joins;

    private User() {}
}
