package com.mishop.main.builder;

import com.mishop.main.dto.ProductoDTO;
import com.mishop.main.model.Producto;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoBuilder {

    public Producto buildProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setProducto_id(productoDTO.getProducto_id());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setExistencia(productoDTO.getExistencia());
        producto.setImagen(productoDTO.getImagen());
        producto.setCategoria_id(productoDTO.getCategoria_id());
        return producto;
    }

    public ProductoDTO buildProductoDTO(Producto producto) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setProducto_id(producto.getProducto_id());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setExistencia(producto.getExistencia());
        productoDTO.setImagen(producto.getImagen());
        productoDTO.setCategoria_id(producto.getCategoria_id());
        productoDTO.setCategoria(producto.getCategoria().getCategoria());
        productoDTO.setPrecioFormated("Gs. " + decimalFormat.format(producto.getPrecio()));
        return productoDTO;
    }

    public List<ProductoDTO> buildListDTO(List<Producto> productos) {
        List<ProductoDTO> productoDTOS = new ArrayList<>();
        for (Producto e : productos) {
            productoDTOS.add(buildProductoDTO(e));
        }
        return productoDTOS;
    }

}
