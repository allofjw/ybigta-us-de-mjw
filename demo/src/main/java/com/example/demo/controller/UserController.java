package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/users")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User req){
        User user=User.builder()
                .id(req.getId())
                .email(req.getEmail())
                .password(req.getPassword())
                .build();
        return userService.insert(user); //DB에 user정보 저장하기
    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

}
