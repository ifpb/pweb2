package br.edu.ifpb.pweb2.apigateway.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServiceFeignClient {

    private final ParticipanteMSClient participanteMSClient;

    public ParticipanteServiceFeignClient(ParticipanteMSClient participanteMSClient) {
        this.participanteMSClient = participanteMSClient;
    }

    public List<String> listarNomeParticipantesAtivos() {
        return participanteMSClient.listarNomesParticipantes();
    }

}
