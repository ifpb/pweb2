package br.edu.ifpb.eventosdominio.domain.participante.eventos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ParticipanteBloqueado {
    private Integer idParticipante;
    private LocalDateTime dataBloqueio;
    private String motivoBloqueio;
}
