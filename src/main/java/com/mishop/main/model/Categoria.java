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
public class Categoria implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    private String categoria;

    @Override
    public String toString() {
        return "Categoria{" +
                "categoria_id=" + id_categoria +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public Categoria(Integer categoria_id, String categoria) {
        this.id_categoria = categoria_id;
        this.categoria = categoria;
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_categoria);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.id_categoria, other.id_categoria)) {
            return false;
        }
        return true;
    }
    

}
