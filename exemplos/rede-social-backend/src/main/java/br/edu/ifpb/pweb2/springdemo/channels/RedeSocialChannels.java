package br.edu.ifpb.pweb2.springdemo.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RedeSocialChannels {

    String REDE_SOCIAL_REQUESTS = "redeSocialRequests";

    String SAGA_REPLY = "sagaReply";

    @Input(REDE_SOCIAL_REQUESTS)
    SubscribableChannel redeSocialRequests();

    @Output(SAGA_REPLY)
    MessageChannel sagaReply();

}
