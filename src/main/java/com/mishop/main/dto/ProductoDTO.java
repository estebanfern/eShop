package com.mishop.main.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer producto_id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private String precioFormated;
    private Integer existencia;
    private String imagen;
    private MultipartFile imagenNativa;
    private Integer categoria_id;
    private String categoria;

}
