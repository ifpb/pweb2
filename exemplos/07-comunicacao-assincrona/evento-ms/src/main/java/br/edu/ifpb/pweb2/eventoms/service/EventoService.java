package br.edu.ifpb.pweb2.eventoms.service;

import br.edu.ifpb.pweb2.eventoms.channel.ParticipanteChannel;
import br.edu.ifpb.pweb2.eventoms.domain.Evento;
import br.edu.ifpb.pweb2.eventoms.domain.dto.CriarEventoDTO;
import br.edu.ifpb.pweb2.eventoms.domain.dto.ParticipanteRegistrado;
import br.edu.ifpb.pweb2.eventoms.repository.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public Evento criarEvento(CriarEventoDTO criarEventoDTO) throws EventoException {
        try {
            Evento evento = Evento.criarEvento(criarEventoDTO);
            return this.eventoRepository.save(evento);
        } catch (Exception e) {
            throw new EventoException("Falha ao criar evento");
        }
    }


    @StreamListener(ParticipanteChannel.INPUT)
    @SendTo(ParticipanteChannel.OUTPUT)
    public Message<?> receberNovoParticipante(ParticipanteRegistrado participanteRegistrado) {
        Evento evento = eventoRepository.findAll().stream().findFirst().get();
        evento.getParticipantes().add(participanteRegistrado.getNomeParticipante());
        eventoRepository.save(evento);
        return new GenericMessage<>(participanteRegistrado);
    }



}
