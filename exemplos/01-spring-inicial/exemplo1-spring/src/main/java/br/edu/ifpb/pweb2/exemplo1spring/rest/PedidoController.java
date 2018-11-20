package br.edu.ifpb.pweb2.exemplo1spring.rest;

import br.edu.ifpb.pweb2.exemplo1spring.entities.Pedido;
import br.edu.ifpb.pweb2.exemplo1spring.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController(value = "/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        pedido.setDataPedido(ZonedDateTime.now());
        Pedido pedidoCriado = pedidoService.salvarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

}
