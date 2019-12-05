package br.edu.ifpb.participantems.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ParticipanteChannel {

    String INPUT = "participanteChannelReply";

    String OUTPUT = "participanteChannel";

    @Input(INPUT)
    SubscribableChannel participanteChannelReply();

    @Output(OUTPUT)
    MessageChannel participanteChannel();

}
