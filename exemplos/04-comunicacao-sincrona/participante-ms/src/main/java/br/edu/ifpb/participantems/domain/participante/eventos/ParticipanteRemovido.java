package br.edu.ifpb.participantems.domain.participante.eventos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ParticipanteRemovido {
    private Integer idParticipante;
    private String nome;
    private String email;
    private LocalDateTime dataExclusao;
}
