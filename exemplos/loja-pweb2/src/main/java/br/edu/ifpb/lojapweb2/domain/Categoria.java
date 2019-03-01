package br.edu.ifpb.lojapweb2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

}
