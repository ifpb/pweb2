package br.edu.ifpb.pweb2.springdemo.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GerenciadorMidiasChannels {

    String CONTEUDO_SERVICE_REQUESTS = "conteudoServiceRequests";

    String SAGA_REPLY = "sagaReply";

    @Input(CONTEUDO_SERVICE_REQUESTS)
    SubscribableChannel conteudoServiceRequests();

    @Output(SAGA_REPLY)
    MessageChannel sagaReply();

}
