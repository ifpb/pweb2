package br.edu.ifpb.pweb2.apigateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "participante-ms")
@Service
public interface ParticipanteMSClient {

    @GetMapping("/api/participante/nomes")
    List<String> listarNomesParticipantes();

}
