package br.edu.ifpb.apigateway.web;

import br.edu.ifpb.apigateway.domain.Pedido;
import br.edu.ifpb.apigateway.service.PedidoException;
import br.edu.ifpb.apigateway.service.PedidoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoResource {

    private final PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> fazerPedido(@RequestBody Pedido pedido)  {
        try {
            return ResponseEntity.ok(pedidoService.criarPedido(pedido));
        } catch (PedidoException e) {
            e.printStackTrace();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("cause", e.getMessage());
            return ResponseEntity.badRequest().headers(httpHeaders).build();
        }
    }

}
