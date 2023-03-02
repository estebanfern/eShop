package com.mishop.main.controller;

import com.mishop.main.config.UserInfoUserDetailsService;
import com.mishop.main.model.Rol;
import com.mishop.main.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserInfoUserDetailsService userService;

    @GetMapping
    public String viewProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = userService.loadUserByUsername(auth.getName());
        model.addAttribute("userName", userInfo.getName());
        model.addAttribute("userEmail", userInfo.getEmail());
        model.addAttribute("userRol", userInfo.getRol());
        model.addAttribute("roles", Rol.values());
        return "profile";
    }
}
