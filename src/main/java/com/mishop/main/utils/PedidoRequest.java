package com.mishop.main.utils;

import com.mishop.main.model.DetallePedido;
import com.mishop.main.model.Pedido;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequest {
    private Pedido pedido;
    private List<DetallePedido> detallesPedido;
}
