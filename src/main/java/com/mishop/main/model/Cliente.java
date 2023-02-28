package com.mishop.main.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Cliente implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer cliente_id;
    private String nombre;
    private String apellido;
    private String ruc;
    private String email;
    private String telefono;
    private String direccion;
    private String ubicacion_maps;

    public Cliente(Integer cliente_id, String nombre, String apellido, String ruc, String email, String telefono, String direccion, String ubicacion_maps) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ubicacion_maps = ubicacion_maps;
    }

    public Cliente(String nombre, String apellido, String ruc, String email, String telefono, String direccion, String ubicacion_maps) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ubicacion_maps = ubicacion_maps;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }  

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion_maps() {
        return ubicacion_maps;
    }

    public void setUbicacion_maps(String ubicacion_maps) {
        this.ubicacion_maps = ubicacion_maps;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente_id=" + cliente_id + ", nombre=" + nombre + ", apellido=" + apellido + ", ruc=" + ruc + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", ubicacion_maps=" + ubicacion_maps + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cliente_id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellido);
        hash = 97 * hash + Objects.hashCode(this.ruc);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        hash = 97 * hash + Objects.hashCode(this.direccion);
        hash = 97 * hash + Objects.hashCode(this.ubicacion_maps);
        return hash;
    }
    
}
