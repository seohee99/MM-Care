package com.service.spring.controller;

import com.service.spring.service.UserService;
import com.service.spring.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:9999"}, allowCredentials = "true")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/", params = {"userEmail"})
    @ResponseBody
    public ResponseEntity getUser(@RequestParam String userEmail, HttpServletRequest request) throws Exception{
        System.out.println("User 조회");
        HttpSession session = request.getSession(false); // 세션 있으면 기존 세션 반환, 없으면 null
//        String userEmail = (String) session.getAttribute("userEmail");

        User result = userService.getUser(userEmail);
        if (result){

        }
        return new ResponseEntity();
    };
}
