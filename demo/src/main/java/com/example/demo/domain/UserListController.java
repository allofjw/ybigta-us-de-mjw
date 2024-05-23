package com.example.demo.domain;


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
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
            System.out.println("d");
            return "index";
        } else {
            return "error";
        }
    }
}
