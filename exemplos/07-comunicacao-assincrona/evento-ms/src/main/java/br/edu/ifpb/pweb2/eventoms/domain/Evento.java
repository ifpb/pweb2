package br.edu.ifpb.pweb2.eventoms.domain;

import br.edu.ifpb.pweb2.eventoms.domain.dto.CriarEventoDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Evento extends AbstractAggregateRoot {

    public enum TipoEvento { CONGRESSO, SIMPOSIO };

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private LocalDate data;
    private TipoEvento tipo;
    private String descricao;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> participantes = new ArrayList();

    public static Evento criarEvento(CriarEventoDTO criarEventoDTO) {
        Evento evento = new Evento();
        evento.data = criarEventoDTO.getData();
        evento.descricao = criarEventoDTO.getDescricao();
        evento.nome = criarEventoDTO.getNome();
        evento.tipo = criarEventoDTO.getTipo();
        return evento;
    }

}
