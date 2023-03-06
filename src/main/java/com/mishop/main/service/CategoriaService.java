package com.mishop.main.service;

import com.mishop.main.model.Categoria;
import com.mishop.main.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    }

}
