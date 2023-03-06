package com.mishop.main.controller;

import com.mishop.main.builder.ProductoBuilder;
import com.mishop.main.dto.ProductoDTO;
import com.mishop.main.model.Producto;
import com.mishop.main.service.CategoriaService;
import com.mishop.main.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoBuilder productoBuilder;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String mainPage(Model model){
        List<Producto> productos = productoService.findAll();
        List<ProductoDTO> productosDTO = productoBuilder.buildListDTO(productos);
        model.addAttribute("productos", productosDTO);
        logger.info("Producto 1 --> " + productos.get(0));
        return "productos";
    }

    @GetMapping("/save/{id}")
    public String editProducto(@PathVariable(value = "id", required = true) Integer id, Model model) {
        model.addAttribute("producto", productoBuilder.buildProductoDTO(productoService.findById(id)));
        model.addAttribute("categorias", categoriaService.findAll());
        return "saveProducto";
    }

    @GetMapping("/save")
    public String newProducto(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        model.addAttribute("categorias", categoriaService.findAll());
        return "saveProducto";
    }

    @PostMapping("/save")
    public String saveNewProducto(ProductoDTO productoDTO) throws IOException {
        productoService.save(productoDTO);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable(value = "id", required = true)Integer id) throws IOException {
        productoService.delete(id);
        return "redirect:/productos?deleteSuccess";
    }
    
}
