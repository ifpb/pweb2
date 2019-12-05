package br.edu.ifpb.participantems;

import br.edu.ifpb.participantems.channel.ParticipanteChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
//@EnableEurekaClient
@EnableBinding(ParticipanteChannel.class)
public class ParticipanteMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParticipanteMSApplication.class, args);
    }

}
