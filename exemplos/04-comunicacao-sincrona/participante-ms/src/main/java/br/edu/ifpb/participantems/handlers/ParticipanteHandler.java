package br.edu.ifpb.participantems.handlers;

import br.edu.ifpb.participantems.domain.participante.eventos.ParticipanteAtivado;
import br.edu.ifpb.participantems.domain.participante.eventos.ParticipanteRegistrado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
public class ParticipanteHandler {

    @TransactionalEventListener
    public void onParticipanteRegistrado(ParticipanteRegistrado evento) {
        log.info("Participante registrado com o id ="+evento.getIdParticipante());
    }

    @TransactionalEventListener
    public void onParticipanteAtivado(ParticipanteAtivado evento) {
        log.info("Participante ativado com o id ="+evento.getIdParticipante());
    }

}
