package br.edu.ifpb.participantems.domain.participante.eventos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ParticipanteRegistrado {

    private Integer idParticipante;
    private String nomeParticipante;
    private LocalDateTime dataRegistro;

}
