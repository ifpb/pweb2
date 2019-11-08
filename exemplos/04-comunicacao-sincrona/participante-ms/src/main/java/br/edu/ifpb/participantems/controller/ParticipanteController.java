package br.edu.ifpb.participantems.controller;

import br.edu.ifpb.participantems.domain.participante.Participante;
import br.edu.ifpb.participantems.domain.participante.dto.RegistroParticipante;
import br.edu.ifpb.participantems.domain.participante.dto.ResultadoAtivacao;
import br.edu.ifpb.participantems.domain.participante.dto.ResultadoRegistro;
import br.edu.ifpb.participantems.service.ParticipanteException;
import br.edu.ifpb.participantems.service.ParticipanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping
    public List<Participante> listarParticipantes() {
        return this.participanteService.listarParticipantes();
    }

    @GetMapping("/nomes")
    public List<String> listarNomesParticipantes() {
        return this.participanteService.listarNomesParticipantes();
    }

    @PostMapping
    public ResponseEntity<ResultadoRegistro> registrarParticipante(@RequestBody RegistroParticipante registroParticipante) {
        try {
            return ResponseEntity.ok(this.participanteService.realizarRegistro(registroParticipante));
        } catch (ParticipanteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<ResultadoAtivacao> ativarParticipante(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(this.participanteService.ativarParticipante(id));
        } catch (ParticipanteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
