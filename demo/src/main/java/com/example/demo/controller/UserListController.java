package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UserListController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer id, Model model) {
        //id 값이 기본키이기 때문에 상관없을 것 같긴 하지만..그럼에도 Null pointer exception
        //발생에 대한 방지가 필요하다라는 생각이 들어서 Optional기능을 활용해보았습니다.
        Optional<User> User = userService.getUserById(id);

        return User.map(user -> {
            model.addAttribute("user", user);
            System.out.println("d");
            return "index";
        }).orElse("User not found with id: " + id);
    }
}
