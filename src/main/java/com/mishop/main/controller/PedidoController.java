package com.mishop.main.controller;

import com.mishop.main.utils.PedidoRequest;
import com.mishop.main.model.Pedido;
import com.mishop.main.utils.PedidoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @GetMapping
    public String pedidos(){
        return "pedidos";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<Pedido> savePedido(@RequestBody PedidoRequest pedidoRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Pedido pedido = pedidoRequest.getPedido();
        pedido.setId_pedido(1);
        pedido.setEstado(PedidoStatus.PENDIENTE_DE_PAGO);
        pedido.setFecha(new Date(System.currentTimeMillis()));
        pedido.setVendedor_name(auth.getName());
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

}
