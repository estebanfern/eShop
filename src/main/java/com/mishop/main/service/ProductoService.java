package com.mishop.main.service;

import com.mishop.main.builder.ProductoBuilder;
import com.mishop.main.controller.ProductoController;
import com.mishop.main.dto.ProductoDTO;
import com.mishop.main.model.Producto;
import com.mishop.main.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Service
public class ProductoService {

    private Logger logger = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ProductoBuilder productoBuilder;


    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Integer id){
        return productoRepository.findById(id).orElse(null);
    }

    public void save(Producto producto){
        productoRepository.save(producto);
    }
    public void save(ProductoDTO productoDTO) throws IOException {
        logger.info("Producto DTO ---> " + productoDTO);
        productoDTO.setImagen(storageService.saveFile(productoDTO.getImagenNativa()));
        Producto producto = productoBuilder.buildProducto(productoDTO);
        productoRepository.save(producto);
    }

}
