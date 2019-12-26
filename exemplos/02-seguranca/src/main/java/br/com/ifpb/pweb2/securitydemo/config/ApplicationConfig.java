package br.com.ifpb.pweb2.securitydemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class ApplicationConfig {

    private AutenticacaoPadrao autenticacaoPadrao = new AutenticacaoPadrao();

    private enum TipoAutenticacao { MEMORIA, BANCO };

    @Data
    public class AutenticacaoPadrao {
        private String login;
        private String senha;
        private String papel;
        private TipoAutenticacao tipoAutenticacao;
    }
}
