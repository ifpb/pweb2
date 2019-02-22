package br.edu.ifpb.kafkaexemplo;

import br.edu.ifpb.kafkaexemplo.domain.Produto;
import br.edu.ifpb.kafkaexemplo.services.Produtor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaExemploApplicationTests {

	@Autowired
	private Produtor produtor;

	@Test
	public void contextLoads() {
	}

	@Test
	public void deveEnviarMensagem() {
		Produto produto = new Produto();
		produto.setNome("Amazon Kindle");
		produto.setPreco(200.00);
		produtor.enviarMensagem(produto);
	}

}
