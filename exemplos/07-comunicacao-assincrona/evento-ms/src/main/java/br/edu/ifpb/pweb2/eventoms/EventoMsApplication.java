package br.edu.ifpb.pweb2.eventoms;

import br.edu.ifpb.pweb2.eventoms.channel.ParticipanteChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ParticipanteChannel.class)
public class EventoMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventoMsApplication.class, args);
    }
}
