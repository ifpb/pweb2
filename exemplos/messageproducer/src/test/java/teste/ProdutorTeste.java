package teste;

import br.edu.ifpb.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ProdutorTeste {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void deveEnviarMensagem(){
        GenericMessage message = new GenericMessage<String>("Mensagem de teste");
        kafkaTemplate.send(message);
    }

}
