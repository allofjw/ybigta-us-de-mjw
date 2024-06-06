package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController
{

    @GetMapping("/login/oauth2/code/google")
    public String login(){
        return "home";
    }
}
