package br.edu.ifpb.participantems.handlers;

import br.edu.ifpb.participantems.channel.ParticipanteChannel;
import br.edu.ifpb.participantems.domain.participante.eventos.ParticipanteAtivado;
import br.edu.ifpb.participantems.domain.participante.eventos.ParticipanteRegistrado;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@AllArgsConstructor
public class ParticipanteHandler {

    private final ParticipanteChannel participanteChannel;

    @TransactionalEventListener
    public void onParticipanteRegistrado(ParticipanteRegistrado evento) {
        participanteChannel.participanteChannel().send(new GenericMessage(evento));
        log.info("Participante registrado com o id ="+evento.getIdParticipante());
    }

    @TransactionalEventListener
    public void onParticipanteAtivado(ParticipanteAtivado evento) {
        log.info("Participante ativado com o id ="+evento.getIdParticipante());
    }

    @StreamListener(ParticipanteChannel.INPUT)
    public void escutarCanalResposta(ParticipanteRegistrado oevento) {
        System.out.println("Serviço de destino processou com sucesso requisição para participante = "+ oevento.getIdParticipante());
    }

}
