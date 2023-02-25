package com.mishop.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/productos")
    public String productos(){
        return "productos";
    }
}
