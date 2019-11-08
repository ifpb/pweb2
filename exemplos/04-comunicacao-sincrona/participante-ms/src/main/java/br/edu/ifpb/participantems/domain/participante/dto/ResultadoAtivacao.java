package br.edu.ifpb.participantems.domain.participante.dto;

import br.edu.ifpb.participantems.domain.participante.Participante;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultadoAtivacao {
    private Integer id;
    private Participante.ParticipanteEstado participanteEstado;
}
