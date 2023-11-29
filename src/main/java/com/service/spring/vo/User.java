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
public class User {
    private long userSeq;
    private String userEmail;
    private String userNickName;
    private String userAddress;
    private String userPhone;
    private String userImg;
    private int userGroupCnt;
    private List<Join> joins;
}
