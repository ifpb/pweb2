package br.edu.ifpb.kafkaexemplo.services;

import br.edu.ifpb.kafkaexemplo.domain.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor {

    private Logger log = LoggerFactory.getLogger(Consumidor.class);

    @KafkaListener(topics = "produtos")
    public void receberMensagem(Produto mensagem) {
        log.info("Chegou mensagem: {}", mensagem);
    }

}
