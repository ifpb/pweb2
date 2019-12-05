package br.edu.ifpb.pweb2.eventoms.domain.dto;

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
