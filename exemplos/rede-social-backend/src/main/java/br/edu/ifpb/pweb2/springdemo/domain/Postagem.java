package br.edu.ifpb.pweb2.springdemo.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Postagem {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    private ZonedDateTime postagem;

    private ZonedDateTime publicacao;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> conteudos;

    private String usuario;
}
