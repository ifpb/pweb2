package br.edu.ifpb.message.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerApplicationTests {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Test
	public void deveEnviarMensagem() {
		kafkaTemplate.send("mensagens", "Mensagem de teste 2");
	}

}
