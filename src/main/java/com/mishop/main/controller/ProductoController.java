package com.mishop.main.controller;

import com.mishop.main.model.Producto;
import com.mishop.main.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {
    private static final String BASE_URL = "/productos";

    @Autowired
    private ProductoService productoService;

    @GetMapping(BASE_URL)
    public String mainPage(Model model){
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }
}
