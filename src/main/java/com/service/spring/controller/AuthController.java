package com.service.spring.controller;

import com.service.spring.dto.OauthToken;
import com.service.spring.service.AuthService;
import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/auth")
    public User authCallback(@RequestParam(name = "code") String code){
        OauthToken oauthToken = authService.getAccessToken(code);
        return userService.save(oauthToken.getAccess_token());
    }


}
