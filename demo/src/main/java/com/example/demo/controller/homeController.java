package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {




    @GetMapping("/nothome")
    public String nothome() {
        return "not home";
    }


}
