package br.edu.ifpb.apigateway.service;

import br.edu.ifpb.apigateway.domain.Pedido;
import br.edu.ifpb.apigateway.web.client.LojaClient;
import br.edu.ifpb.lojapweb2.domain.domain.Cliente;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final LojaClient lojaClient;

    public PedidoService(LojaClient lojaClient) {
        this.lojaClient = lojaClient;
    }

    public Pedido criarPedido(Pedido pedido) throws PedidoException {

        Cliente cliente = null;
        try {
            lojaClient.recuperarCliente(pedido.getIdCliente()).getBody();
        } catch (FeignException e) {
            e.printStackTrace();
            throw new PedidoException("Cliente não existe");
        }

        List<Long> idsProdutosExistentes = lojaClient.listarProdutos().getBody().stream().map( p -> p.getId()).collect(Collectors.toList());

        if (!idsProdutosExistentes.containsAll(pedido.getIdsProdutos())) {
            throw new PedidoException("Produtos inválidos");
        }

        pedido.setIdPedido(UUID.randomUUID().toString());
        pedido.setData(ZonedDateTime.now());

        return pedido;

    }

}
