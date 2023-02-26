package com.mishop.main.service;

import com.mishop.main.model.Producto;
import com.mishop.main.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

}
