package br.edu.ifpb.eventosdominio.domain.evento;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;
    private LocalDateTime data;

}
