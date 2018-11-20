package br.edu.ifpb.pweb2.exemplo1spring.events;

public class PedidoCriado {
    private Long idPedido;

    public PedidoCriado(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
