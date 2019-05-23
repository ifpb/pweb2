package br.edu.ifpb.apigateway.canais;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface SagaChannels {

    String RESPOSTAS = "respostas";

    String CONTEUDO_REQUESTS = "conteudoRequests";

    String REDESOCIAL_REQUESTS = "redeSocialRequests";

    String YOUTUBE_REQUESTS = "youtubeRequests";

    @Input(SagaChannels.RESPOSTAS)
    SubscribableChannel respostas();

    @Output(SagaChannels.CONTEUDO_REQUESTS)
    MessageChannel conteudoRequests();

    @Output(SagaChannels.REDESOCIAL_REQUESTS)
    MessageChannel redeSocialRequests();

    @Output(SagaChannels.YOUTUBE_REQUESTS)
    MessageChannel youtubeRequests();

}
