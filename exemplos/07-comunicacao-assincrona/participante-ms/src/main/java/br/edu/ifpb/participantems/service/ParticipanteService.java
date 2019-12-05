package br.edu.ifpb.participantems.service;

import br.edu.ifpb.participantems.domain.participante.Participante;
import br.edu.ifpb.participantems.domain.participante.dto.RegistroParticipante;
import br.edu.ifpb.participantems.domain.participante.dto.ResultadoAtivacao;
import br.edu.ifpb.participantems.domain.participante.dto.ResultadoRegistro;
import br.edu.ifpb.participantems.repository.ParticipanteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public ResultadoRegistro realizarRegistro(RegistroParticipante registroParticipante) throws ParticipanteException {
        try {
            Participante participante = Participante.criar(registroParticipante);
            participanteRepository.saveAndFlush(participante);
            return new ResultadoRegistro(participante.getId(), participante.getEstado());
        } catch(Exception e) {
            log.error("Falha ao criar participante", e);
            throw new ParticipanteException("Falha ao registrar participante");
        }
    }

    public ResultadoAtivacao ativarParticipante(Integer id) throws ParticipanteException {
        Participante participante = participanteRepository
                .findById(id).orElseThrow( () -> new ParticipanteException("Participante não encontrado!") );
        participanteRepository.save(participante.ativado());
        return new ResultadoAtivacao(participante.getId(), participante.getEstado());
    }

    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    public List<String> listarNomesParticipantes () {
        return participanteRepository.listarNomesParticipantes();
    }
}
