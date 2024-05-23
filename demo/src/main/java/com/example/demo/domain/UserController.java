package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        return userService.insert(user);
    }

}
