package com.mishop.main.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    private String nombre;
    private String telefono;
    private String ruc;
    private Integer total;
    private Date fecha;
    private String metodo_pago;
    private String direccion;
    private String ubicacion_maps;
    private Integer vendedor_id;
    private String estado;

    public Pedido(Integer id_pedido, String nombre, String telefono, String ruc, Integer total, Date fecha, String metodo_pago, String direccion, String ubicacion_maps, Integer vendedor_id, String estado) {
        this.id_pedido = id_pedido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruc = ruc;
        this.total = total;
        this.fecha = fecha;
        this.metodo_pago = metodo_pago;
        this.direccion = direccion;
        this.ubicacion_maps = ubicacion_maps;
        this.vendedor_id = vendedor_id;
        this.estado = estado;
    }

    public Pedido(String nombre, String telefono, String ruc, Integer total, Date fecha, String metodo_pago, String direccion, String ubicacion_maps, Integer vendedor_id, String estado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruc = ruc;
        this.total = total;
        this.fecha = fecha;
        this.metodo_pago = metodo_pago;
        this.direccion = direccion;
        this.ubicacion_maps = ubicacion_maps;
        this.vendedor_id = vendedor_id;
        this.estado = estado;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
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

    public Integer getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(Integer vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "pedido_id=" + id_pedido + ", nombre=" + nombre + ", telefono=" + telefono + ", ruc=" + ruc + ", total=" + total + ", fecha=" + fecha + ", metodo_pago=" + metodo_pago + ", direccion=" + direccion + ", ubicacion_maps=" + ubicacion_maps + ", vendedor_id=" + vendedor_id + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_pedido;
        return hash;
    }

}
