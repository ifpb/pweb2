package br.edu.ifpb.kafkaexemplo.services;

import br.edu.ifpb.kafkaexemplo.domain.Produto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Produtor {

    private final KafkaTemplate kafkaTemplate;

    public Produtor(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem(Produto produto) {
        kafkaTemplate.send("produtos", produto);
    }

}
