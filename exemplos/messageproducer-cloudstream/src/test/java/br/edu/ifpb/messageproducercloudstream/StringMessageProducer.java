package br.edu.ifpb.messageproducercloudstream;

import br.edu.ifpb.messageproducercloudstream.evento.Evento;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StringMessageProducer.MyProcessor.class, webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = {
		"--spring.cloud.stream.bindings.input.contentType=text/plain",
		"--spring.cloud.stream.bindings.output.contentType=text/plain"})
public class StringMessageProducer {

	@Autowired
	private Processor processor;

	@Autowired
	private MessageCollector messageCollector;

	@Test
	public void deveEnviarMensagem() {
		processor.input().send(new GenericMessage<>("mensagem"));

		Message<String> received = (Message<String>) this.messageCollector
				.forChannel(this.processor.output()).poll();

		assertThat(received.getPayload()).isEqualTo("mensagem");
	}

	@SpringBootApplication
	@EnableBinding(Processor.class)
	public static class MyProcessor {

		@StreamListener(Processor.INPUT)
		@SendTo(Processor.OUTPUT)
		public String tratadorMensagem(String msg) {
			System.out.println("MENSAGEM CHEGOU = "+msg);
			return msg;
		}

	}

}
