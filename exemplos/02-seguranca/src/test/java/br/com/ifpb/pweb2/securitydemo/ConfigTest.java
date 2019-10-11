package br.com.ifpb.pweb2.securitydemo;

import br.com.ifpb.pweb2.securitydemo.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ConfigTest {

    @Autowired
    private ApplicationConfig applicationConfig;

//    @Value("${app.autenticacaoPadrao.login}")
//    private String loginPadrao;

    @Test
    public void testarCredenciaisPadroes() {

        assertNotNull(applicationConfig);
        assertNotNull(applicationConfig.getAutenticacaoPadrao().getLogin());
        assertNotNull(applicationConfig.getAutenticacaoPadrao().getSenha());
        assertNotNull(applicationConfig.getAutenticacaoPadrao().getPapel());
        assertNotNull(applicationConfig.getAutenticacaoPadrao().getTipoAutenticacao());

        log.info("Login padrão = "+ applicationConfig.getAutenticacaoPadrao().getLogin());
        log.info("Senha padrão = "+ applicationConfig.getAutenticacaoPadrao().getSenha());
        log.info("Papel padrão = "+ applicationConfig.getAutenticacaoPadrao().getPapel());
        log.info("Papel padrão = "+ applicationConfig.getAutenticacaoPadrao().getTipoAutenticacao());


    }

}
