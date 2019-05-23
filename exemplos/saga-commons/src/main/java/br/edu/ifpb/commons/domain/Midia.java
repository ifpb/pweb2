package br.edu.ifpb.commons.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Midia {

    @Id
    @GeneratedValue
    private Long id;
    private String arquivo;
    private String formato;
    private Long tamanho;

    @ManyToOne
    private Conteudo conteudo;

}
