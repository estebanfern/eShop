package com.mishop.main.controller;

import com.mishop.main.model.Producto;
import com.mishop.main.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String mainPage(Model model){
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/new")
    public String viewNewProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "newProducto";
    }

    @PostMapping("/new")
    public String saveNewProducto(Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }
    
}
