package br.edu.ifpb.pweb2.exemplo1spring.entities;

import javax.persistence.*;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
