package br.edu.ifpb.eventosdominio.domain.participante.dto;

import br.edu.ifpb.eventosdominio.domain.participante.Participante;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultadoRegistro {

    private Integer id;
    private Participante.ParticipanteEstado participanteEstado;

}
