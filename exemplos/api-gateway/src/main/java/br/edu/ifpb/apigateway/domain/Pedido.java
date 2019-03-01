package br.edu.ifpb.apigateway.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private Long idCliente;
    private List<Long> idsProdutos;

    private String idPedido;

    private ZonedDateTime data;

}
