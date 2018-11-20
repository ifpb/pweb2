package br.edu.ifpb.pweb2.exemplo1spring.service;

import br.edu.ifpb.pweb2.exemplo1spring.entities.Pedido;
import br.edu.ifpb.pweb2.exemplo1spring.events.PedidoCriado;
import br.edu.ifpb.pweb2.exemplo1spring.events.PedidoEmProcessamento;
import br.edu.ifpb.pweb2.exemplo1spring.events.PedidoFinalizado;
import br.edu.ifpb.pweb2.exemplo1spring.repositories.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private Logger log = LoggerFactory.getLogger(PedidoService.class);

    private final PedidoRepository pedidoRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public PedidoService(PedidoRepository pedidoRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.pedidoRepository = pedidoRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Pedido salvarPedido(Pedido pedido) {
        pedidoRepository.save(pedido.marcarComoCriado());
        applicationEventPublisher.publishEvent(pedido.pedidoCriado());
        return pedido;
    }

    public Pedido finalizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido.pedidoFinalizado());
    }

    public Pedido dispararPedidoEmProcessamento(Pedido pedido) {
        return pedidoRepository.save(pedido.pedidoEmProcessamento());
    }

    @EventListener(PedidoCriado.class)
    public void pedidoCriado(PedidoCriado evento) {
        //Mandar email pro usuario....
        log.info("Pedido criado com o id "+ evento.getIdPedido());
    }

    @EventListener(PedidoEmProcessamento.class)
    public void pedidoEmProcessamento(PedidoEmProcessamento evento) {
        log.info("Pedido em processamento com o id " + evento.getIdPedido());
    }

    @EventListener(PedidoFinalizado.class)
    public void pedidoFinalizado(PedidoFinalizado evento) {
        log.info("Pedido finalizado com o id "+ evento.getIdPedido());
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }


}
