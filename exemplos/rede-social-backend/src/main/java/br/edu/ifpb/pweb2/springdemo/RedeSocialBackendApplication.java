package br.edu.ifpb.pweb2.springdemo;

import br.edu.ifpb.messageproducercloudstream.canais.EventosChannels;
import br.edu.ifpb.pweb2.springdemo.channels.RedeSocialChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableFeignClients
@EnableBinding({EventosChannels.class, RedeSocialChannels.class})
public class RedeSocialBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedeSocialBackendApplication.class, args);
	}

}
