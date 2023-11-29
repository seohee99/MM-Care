package com.service.spring.service;

import com.service.spring.dto.KakaoProfile;
import com.service.spring.dto.OauthToken;

public interface AuthService {
    OauthToken getAccessToken(String code);
    KakaoProfile getKakaoProfile(String token);
}
