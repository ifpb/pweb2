package br.edu.ifpb.apigateway;

import br.edu.ifpb.apigateway.web.client.LojaClient;
import br.edu.ifpb.lojapweb2.domain.domain.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiGatewayApplication.class)
public class ClientesTeste {

    @Autowired
    private LojaClient lojaClient;

    @Test
    public void criarClient() {
        Cliente cliente = new Cliente();
        cliente.setLogin("diego");
        cliente.setNome("Diego");
        cliente.setSenha("32131231");
        cliente.setCpf("231.123.213-22");
        lojaClient.criarCliente(cliente);
    }
}
