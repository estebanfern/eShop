package com.mishop.main.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mishop.main.model.Categoria;
import com.mishop.main.repository.CategoriaRepository;

@RestController
public class CategoriaRest {
    private static final String BASE_URL = "/api/categoria";
    private final CategoriaRepository categoriaRepository;
    
    public CategoriaRest(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @GetMapping(BASE_URL + "/list")
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }

    @GetMapping(BASE_URL + "/{id}")
    public Categoria getCategoria(@PathVariable Integer id){
        return categoriaRepository.findById(id).orElse(null);
    }

    @PostMapping(BASE_URL + "/save")
    public Categoria save(@RequestBody Map<String, String> body){
        String categoria = body.get("categoria");
        Categoria categoriaSaved = new Categoria(categoria);
        return categoriaRepository.save(categoriaSaved);
    }

    @DeleteMapping(BASE_URL + "/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        categoriaRepository.deleteById(id);
        return true;
    }
    
}
