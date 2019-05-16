package br.edu.ifpb.messageproducercloudstream.canais;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EventosChannels {

    String ENTRADA = "eventosEntrada";

    String SAIDA = "eventosSaida";

    @Input(EventosChannels.ENTRADA)
    SubscribableChannel eventosEntrada();

    @Output(EventosChannels.SAIDA)
    MessageChannel eventosSaida();

}