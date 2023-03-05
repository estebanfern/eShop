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

    public ProductoDTO(Integer producto_id, String nombre, String descripcion, Integer precio, String precioFormated, Integer existencia, String imagen, Integer categoria_id) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioFormated = precioFormated;
        this.existencia = existencia;
        this.imagen = imagen;
        this.categoria_id = categoria_id;
    }

    public ProductoDTO(String nombre, String descripcion, Integer precio, String precioFormated, Integer existencia, MultipartFile imagenNativa, Integer categoria_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioFormated = precioFormated;
        this.existencia = existencia;
        this.imagenNativa = imagenNativa;
        this.categoria_id = categoria_id;
    }

    public ProductoDTO(String nombre, String descripcion, Integer precio, String precioFormated, Integer existencia, String imagen, MultipartFile imagenNativa, Integer categoria_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioFormated = precioFormated;
        this.existencia = existencia;
        this.imagen = imagen;
        this.imagenNativa = imagenNativa;
        this.categoria_id = categoria_id;
    }
}
