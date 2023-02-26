package com.mishop.main.repository;
import com.mishop.main.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
