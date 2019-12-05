package br.edu.ifpb.pweb2.eventoms.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ParticipanteChannel {


    String INPUT = "participanteChannel";

    String OUTPUT = "participanteChannelReply";

    @Output(OUTPUT)
    MessageChannel participanteChannelReply();

    @Input(INPUT)
    SubscribableChannel participanteChannel();
}
