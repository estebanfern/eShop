package com.mishop.main.controller.rest;

import com.mishop.main.config.UserInfoUserDetailsService;
import com.mishop.main.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UsuarioRest {

    private static final String BASE_URL = "/api/usuario";
    @Autowired
    private UserInfoUserDetailsService service;
    @PostMapping(BASE_URL + "/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }
}
