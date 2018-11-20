package br.edu.ifpb.pweb2.exemplo1spring.events;

public class PedidoFinalizado {
    private Long idPedido;

    public PedidoFinalizado(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
