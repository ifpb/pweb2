package br.edu.ifpb.pweb2.apigateway.controller;

import br.edu.ifpb.pweb2.apigateway.service.ParticipanteServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipanteController {

    private final ParticipanteServiceFeignClient participanteService;

    public ParticipanteController(ParticipanteServiceFeignClient participanteService) {
        this.participanteService = participanteService;
    }


    @GetMapping("/nomesparticipantes")
    public List<String> nomesParticipantes() {
        return this.participanteService.listarNomeParticipantesAtivos();
    }

}
