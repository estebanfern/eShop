package com.mishop.main.controller.rest;

import com.mishop.main.model.Cliente;
import com.mishop.main.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteRest {
    private static final String BASE_URL = "/api/cliente";
    private final ClienteRepository clienteRepository;

    public ClienteRest(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping(BASE_URL + "/list")
    public List<Cliente> getProductos(){
        return clienteRepository.findAll();
    }

    @GetMapping(BASE_URL + "/{id}")
    public Cliente getProducto(@PathVariable Integer id){
        Optional<Cliente> producto = clienteRepository.findById(id);
        return producto.orElse(null);
    }

    @PostMapping(BASE_URL + "/save")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente clienteSaved = clienteRepository.save(cliente);
        return new ResponseEntity<>(clienteSaved, HttpStatus.OK);
    }

    @DeleteMapping(BASE_URL + "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    

    
}
