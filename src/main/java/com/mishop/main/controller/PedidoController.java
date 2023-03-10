package com.mishop.main.controller;

import com.mishop.main.config.UserInfoUserDetailsService;
import com.mishop.main.model.Rol;
import com.mishop.main.model.UserInfo;
import com.mishop.main.service.PedidoService;
import com.mishop.main.utils.PedidoRequest;
import com.mishop.main.model.Pedido;
import com.mishop.main.utils.PedidoStatus;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private UserInfoUserDetailsService userService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String pedidos(Model model){
        Map<String, String> css = new HashMap<>();
        css.put(PedidoStatus.PENDIENTE_DE_PAGO, "badge badge-warning");
        css.put(PedidoStatus.ERROR, "badge badge-danger");
        css.put(PedidoStatus.RECHAZADO, "badge badge-danger");
        css.put(PedidoStatus.PENDIENTE_DE_ENVIO, "badge badge-info");
        css.put(PedidoStatus.VERIFICADO, "badge badge-primary");
        css.put(PedidoStatus.ENTREGADO, "badge badge-success");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<Integer, String> vendedores = new HashMap<>();
        List<UserInfo> users = userService.getAll();
        Integer userId = null;
        for (UserInfo u : users) {
            vendedores.put(u.getId(), u.getName());
            if (auth.getName().equals(u.getName())){
                userId = u.getId();
            }
        }

        List<Pedido> pedidos;
        if (auth.getAuthorities().equals(Collections.singletonList(new SimpleGrantedAuthority(Rol.ROLE_ADMIN.name())))){
            pedidos = pedidoService.listAllPedidos();
        }else {
            pedidos = pedidoService.listAllPedidosOfVendedor(userId);
        }

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", css);
        model.addAttribute("vendedores", vendedores);
        return "pedidos";
    }

    @GetMapping("/confirmar")
    public String confirmarPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "confirmarPedido";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<String> savePedido(@RequestBody PedidoRequest pedidoRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Pedido pedido = pedidoRequest.getPedido();
        pedido.setEstado(PedidoStatus.PENDIENTE_DE_PAGO);
        pedido.setFecha(new Date(System.currentTimeMillis()));
        pedido.setVendedor_id(userService.loadUserByUsername(auth.getName()).getId());
        return pedidoService.createPedido(pedido, pedidoRequest.getDetallesPedido());
    }

}
