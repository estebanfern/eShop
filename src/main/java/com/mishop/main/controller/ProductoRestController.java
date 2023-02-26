package com.mishop.main.controller;

import com.mishop.main.model.Producto;
import com.mishop.main.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoRestController {
    private static final String BASE_URL = "/api/producto";
    private final ProductoRepository productoRepository;

    public ProductoRestController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping(BASE_URL + "/list")
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    @GetMapping(BASE_URL + "/{id}")
    public Producto getProducto(@PathVariable Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @PostMapping(BASE_URL + "/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto productoSaved = productoRepository.save(producto);
        return new ResponseEntity<>(productoSaved, HttpStatus.OK);
    }

    @DeleteMapping(BASE_URL + "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        productoRepository.deleteById(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
