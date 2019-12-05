package br.edu.ifpb.pweb2.eventoms.controller;


import br.edu.ifpb.pweb2.eventoms.domain.Evento;
import br.edu.ifpb.pweb2.eventoms.domain.dto.CriarEventoDTO;
import br.edu.ifpb.pweb2.eventoms.service.EventoException;
import br.edu.ifpb.pweb2.eventoms.service.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/evento")
@AllArgsConstructor
public class EventoController {

    private final EventoService eventoService;

    @PostMapping
    public Evento criarEvento(@Valid @RequestBody CriarEventoDTO criarEventoDTO) throws EventoException {
        return eventoService.criarEvento(criarEventoDTO);
    }

}
