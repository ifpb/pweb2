package br.edu.ifpb.message.producer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "mensagens")
    public void messageListener(String mensagem) {
        System.out.println("MENSAGEM RECEBIDA = "+mensagem);
    }

}
