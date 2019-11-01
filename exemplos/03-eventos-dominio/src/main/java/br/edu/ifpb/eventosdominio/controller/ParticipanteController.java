package br.edu.ifpb.eventosdominio.controller;

import br.edu.ifpb.eventosdominio.domain.participante.Participante;
import br.edu.ifpb.eventosdominio.domain.participante.dto.RegistroParticipante;
import br.edu.ifpb.eventosdominio.domain.participante.dto.ResultadoAtivacao;
import br.edu.ifpb.eventosdominio.domain.participante.dto.ResultadoRegistro;
import br.edu.ifpb.eventosdominio.service.ParticipanteException;
import br.edu.ifpb.eventosdominio.service.ParticipanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
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
