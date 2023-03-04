package com.mishop.main.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private String producto;
    private String descripcion;
    private Integer precio;
    private Integer existencia;
    private MultipartFile imagen;
    private Integer categoria_id;
    
}
