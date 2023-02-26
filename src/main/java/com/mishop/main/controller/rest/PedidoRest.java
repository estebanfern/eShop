package com.mishop.main.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mishop.main.model.Pedido;
import com.mishop.main.repository.PedidoRepository;

@RestController
public class PedidoRest {
    
    private static final String BASE_URL = "/api/pedidos";
    private final PedidoRepository pedidoRepository;

    
    public PedidoRest(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping(BASE_URL + "/list")
    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }
    
    @GetMapping(BASE_URL + "/{id}")
    public Pedido getPedido(@PathVariable Integer id){
        return pedidoRepository.findById(id).orElse(null);
    }

    @PostMapping(BASE_URL + "/save")
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        Pedido pedidoSaved = pedidoRepository.save(pedido);
        return new ResponseEntity<>(pedidoSaved, HttpStatus.OK);
    }
    
    @DeleteMapping(BASE_URL + "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        pedidoRepository.deleteById(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
