package br.edu.ifpb.lojapweb2.domain.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
public class Cliente {

    private Long id;

    private String nome;

    private String login;

    private String senha;

    private String cpf;

}
