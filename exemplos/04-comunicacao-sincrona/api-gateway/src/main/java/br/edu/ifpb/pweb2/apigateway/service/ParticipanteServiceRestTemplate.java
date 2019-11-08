package br.edu.ifpb.pweb2.apigateway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ParticipanteServiceRestTemplate {

    private final RestTemplate restTemplate;

    public ParticipanteServiceRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> listarNomeParticipantesAtivos() {
        String url = "http://localhost:8080/api-gateway/participante-ms/participante";
        List<String> resultado = restTemplate.getForObject(url, List.class);
        return resultado;
    }

}
