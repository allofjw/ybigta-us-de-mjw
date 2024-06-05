package com.example.demo.controller;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller

public class LoginController {


    private final HttpSession httpSession;


    @GetMapping("/a")
    public String root(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("email", user.getEmail());
        }

        return "home";
    }
}
