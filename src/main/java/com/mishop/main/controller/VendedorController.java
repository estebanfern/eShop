package com.mishop.main.controller;

import com.mishop.main.config.UserInfoUserDetailsService;
import com.mishop.main.model.Rol;
import com.mishop.main.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private UserInfoUserDetailsService service;

    @GetMapping
    public String listVendedores(Model model){
        model.addAttribute("vendedores", service.getAll());
        return "vendedores";
    }

    @GetMapping("/new")
    public String viewNewVendedor(Model model) {
        model.addAttribute("user", new UserInfo());
        return "newVendedor";
    }

    @PostMapping("/new")
    public String saveNewVendedor(UserInfo userInfo) {
        userInfo.setPassword("123456");
        userInfo.setRol(Rol.ROLE_USER);
        service.addUser(userInfo);
        return "redirect:/vendedores";
    }

}
