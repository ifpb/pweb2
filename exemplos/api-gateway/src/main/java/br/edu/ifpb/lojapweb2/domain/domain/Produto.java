package br.edu.ifpb.lojapweb2.domain.domain;

import lombok.Value;

import java.util.List;

@Value
public class Produto {

    private Long id;

    private String nome;

    private Double preco;

    private String descricao;

    private List<Categoria> categoria;

}
