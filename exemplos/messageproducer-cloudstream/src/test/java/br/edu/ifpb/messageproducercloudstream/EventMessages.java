package br.edu.ifpb.messageproducercloudstream;

import br.edu.ifpb.messageproducercloudstream.canais.EventosChannels;
import br.edu.ifpb.messageproducercloudstream.evento.Evento;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EventMessages.EventProcessor.class)
public class EventMessages {

	@Autowired
	private EventosChannels eventosChannels;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void deveEnviarMensagem() {
		eventosChannels.eventosEntrada().send(MessageBuilder.withPayload(new Evento("ConteudoRemovido", 1L)).build());

		Message<String> received = (Message<String>) this.messageCollector.forChannel(this.eventosChannels.eventosRetorno()).poll();

		assertThat(received.getPayload()).isEqualTo("{ 'resultado': 'sucesso' }");
	}

	@SpringBootApplication
	@EnableBinding(EventosChannels.class)
	public static class EventProcessor {

		@StreamListener(EventosChannels.ENTRADA)
		@SendTo(EventosChannels.RETORNO)
		public String tratadorMensagem(Evento evento) {
			System.out.println("EVENTO CHEGOU = "+evento.getNome());
			return "{ 'resultado': 'sucesso' }";
		}

	}

}
