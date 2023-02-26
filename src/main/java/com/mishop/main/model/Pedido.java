package com.mishop.main.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedido_id;
    private String nombre;
    private String telefono;
    private String ruc;
    private Integer total;
    private String fecha;
    private String hora;
    private String metodo_pago;
    private String direccion;
    private String ubicacion_maps;
    private String vendedor_id;
    private String estado;
    
    public Pedido(Integer pedido_id, String nombre, String telefono, String ruc, Integer total, String fecha, String hora, String metodo_pago, String direccion, String ubicacion_maps, String vendedor_id, String estado) {
        this.pedido_id = pedido_id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruc = ruc;
        this.total = total;
        this.fecha = fecha;
        this.hora = hora;
        this.metodo_pago = metodo_pago;
        this.direccion = direccion;
        this.ubicacion_maps = ubicacion_maps;
        this.vendedor_id = vendedor_id;
        this.estado = estado;
    }

    public Pedido(String nombre, String telefono, String ruc, Integer total, String fecha, String hora, String metodo_pago, String direccion, String ubicacion_maps, String vendedor_id, String estado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruc = ruc;
        this.total = total;
        this.fecha = fecha;
        this.hora = hora;
        this.metodo_pago = metodo_pago;
        this.direccion = direccion;
        this.ubicacion_maps = ubicacion_maps;
        this.vendedor_id = vendedor_id;
        this.estado = estado;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public String getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(String vendedor_id) {
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
        return "Pedido{" + "pedido_id=" + pedido_id + ", nombre=" + nombre + ", telefono=" + telefono + ", ruc=" + ruc + ", total=" + total + ", fecha=" + fecha + ", hora=" + hora + ", metodo_pago=" + metodo_pago + ", direccion=" + direccion + ", ubicacion_maps=" + ubicacion_maps + ", vendedor_id=" + vendedor_id + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.pedido_id;
        return hash;
    }

}
