package com.mishop.main.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Producto implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer producto_id;
    
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer existencia;
    private String imagen;
    private Integer categoria_id;

    public Producto(Integer producto_id, String producto, String descripcion, Integer precio, Integer existencia, String imagen, Integer categoria_id) {
        this.producto_id = producto_id;
        this.nombre = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.imagen = imagen;
        this.categoria_id = categoria_id;
    }

    public Producto(String producto, String descripcion, Integer precio, Integer existencia, String imagen, Integer categoria_id) {
        this.nombre = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.imagen = imagen;
        this.categoria_id = categoria_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(producto_id, producto.producto_id) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(precio, producto.precio) && Objects.equals(existencia, producto.existencia) && Objects.equals(imagen, producto.imagen) && Objects.equals(categoria_id, producto.categoria_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto_id, descripcion, precio, existencia, imagen, categoria_id);
    }
}
