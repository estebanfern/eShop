package com.mishop.main.controller;

import com.mishop.main.model.Categoria;
import com.mishop.main.service.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    @PostMapping("/save")
    public String saveCategoria(String id_categoria, String categoria) {
        Categoria categoriaDAO;
        if (id_categoria.equals("")){
            categoriaDAO = new Categoria(categoria);
        }else{
            categoriaDAO = new Categoria(Integer.parseInt(id_categoria), categoria);
        }
        categoriaService.save(categoriaDAO);
        return "redirect:/categorias?saveSuccess";
    }

}
