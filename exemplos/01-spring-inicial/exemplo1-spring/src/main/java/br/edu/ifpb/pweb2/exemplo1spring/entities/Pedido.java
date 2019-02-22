package br.edu.ifpb.pweb2.exemplo1spring.entities;

import br.edu.ifpb.pweb2.exemplo1spring.events.PedidoCriado;
import br.edu.ifpb.pweb2.exemplo1spring.events.PedidoEmProcessamento;
import br.edu.ifpb.pweb2.exemplo1spring.events.PedidoFinalizado;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Pedido extends AbstractAggregateRoot<Pedido> {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemPedido> itens;

    private Long usuarioId;

    private ZonedDateTime dataPedido;

    public enum PedidoStatus { CRIADO, EM_PROCESSAMENTO, FINALIZADO};

    private PedidoStatus status;

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public ZonedDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(ZonedDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Pedido marcarComoCriado() {
        this.setStatus(PedidoStatus.CRIADO);
        return this;
    }

    public PedidoCriado pedidoCriado() {
        return registerEvent(new PedidoCriado(getId()));
    }

    public Pedido pedidoEmProcessamento() {
        this.setStatus(PedidoStatus.EM_PROCESSAMENTO);
        return andEvent(new PedidoEmProcessamento(this.id));
    }

    public Pedido pedidoFinalizado() {
        this.setStatus(PedidoStatus.FINALIZADO);
        return andEvent(new PedidoFinalizado(getId()));
    }

}
