package com.service.spring.service.impl;


import com.service.spring.dao.UserDAO;
import com.service.spring.dto.KakaoProfile;
import com.service.spring.service.AuthService;
import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthService authService;

    public User save(String token){
        KakaoProfile profile = authService.getKakaoProfile(token);

        User user = userDAO.findUserByKakaoEmail(profile.getKakao_account().getEmail());

        if(user == null) {
            user = User.builder()
                    .userEmail(profile.getKakao_account().getEmail())
                    .userNickName(profile.getKakao_account().getProfile().getNickname())
                    .userImg(profile.getKakao_account().getProfile().getProfile_image_url())
                    .build();
            userDAO.save(user);
        }

        return user;
    }

    @Override
    public User findUserByKakaoEmail(String email) {
        return userDAO.findUserByKakaoEmail(email);
    }
}
