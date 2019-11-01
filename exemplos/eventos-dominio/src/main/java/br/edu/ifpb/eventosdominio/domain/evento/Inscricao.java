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
public class Inscricao {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime dataInscricao;

    private double preco;
    private String tipoEvento;
    private String tipoParticipacao;

}
