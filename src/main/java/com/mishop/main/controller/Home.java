package com.mishop.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/inicio")
    public String home(){
        return "inicio";
    }

    @GetMapping("/")
    public String inicio(){
        return "inicio";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/pedidos")
    public String pedidos(){
        return "pedidos";
    }
}
