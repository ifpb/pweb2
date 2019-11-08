package br.edu.ifpb.participantems.domain.participante.eventos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParticipanteDesbloqueado {
    private Integer idParticipante;
    private LocalDateTime dataDesbloqueio;
}
