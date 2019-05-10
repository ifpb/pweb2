package br.edu.ifpb.messageproducercloudstream;

import br.edu.ifpb.messageproducercloudstream.canais.EventosChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding({Processor.class, EventosChannels.class})
public class MessageproducerCloudstreamApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessageproducerCloudstreamApplication.class, args);
	}

}
