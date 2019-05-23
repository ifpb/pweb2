package br.edu.ifpb.pweb2.springdemo;

import br.edu.ifpb.messageproducercloudstream.canais.EventosChannels;
import br.edu.ifpb.pweb2.springdemo.channels.GerenciadorMidiasChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({EventosChannels.class, GerenciadorMidiasChannels.class})
public class GerenciadorMidiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorMidiasApplication.class, args);
	}

}
