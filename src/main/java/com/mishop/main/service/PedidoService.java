package com.mishop.main.service;

import com.mishop.main.model.DetallePedido;
import com.mishop.main.model.Pedido;
import com.mishop.main.model.Producto;
import com.mishop.main.repository.DetallePedidoRepository;
import com.mishop.main.repository.PedidoRepository;
import com.mishop.main.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Pedido> listAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResponseEntity<String> createPedido(Pedido pedido, List<DetallePedido> detallesPedido) {
        Optional<Producto> producto;
        Integer amount = 0;
        for (DetallePedido d : detallesPedido) {
            producto = productoRepository.findById(d.getProducto_id());
            if (producto.isPresent()){
                if (producto.get().getExistencia() < d.getCantidad()){
                    throw new IllegalArgumentException(String.format("Detalle de producto %d -> %d es mayor a %d",
                            d.getPedido_id(), d.getCantidad(), producto.get().getExistencia()));
                }else {
                    amount = amount + producto.get().getPrecio() * d.getCantidad();
                    producto.get().setExistencia(producto.get().getExistencia() - d.getCantidad());
                }
            }else{
                throw new IllegalArgumentException("Invalid pedido_id");
            }
        }
        pedido.setTotal(amount);
        Pedido pedidoSaved = pedidoRepository.save(pedido);
        for (DetallePedido d : detallesPedido) {
            d.setPedido_id(pedidoSaved.getId_pedido());
            detallePedidoRepository.save(d);
        }

        return new ResponseEntity<>("Pedido guardado satisfactoriamente", HttpStatus.OK);
    }

}
