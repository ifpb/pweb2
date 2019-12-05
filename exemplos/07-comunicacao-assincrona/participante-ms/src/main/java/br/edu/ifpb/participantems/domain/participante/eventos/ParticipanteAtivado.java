package br.edu.ifpb.participantems.domain.participante.eventos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ParticipanteAtivado {
    private Integer idParticipante;
    private LocalDateTime dataAtivacao;
}
