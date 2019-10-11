package br.com.ifpb.pweb2.securitydemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConditionalOnProperty(value = "app.autenticacaoPadrao.tipoAutenticacao", havingValue = "MEMORIA")
@Order(20)
public class InMemoryWebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final ApplicationConfig applicationConfig;

    private final PasswordEncoder passwordEncoder;

    public InMemoryWebSecurityConfig(ApplicationConfig applicationConfig, PasswordEncoder passwordEncoder) {
        this.applicationConfig = applicationConfig;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser(applicationConfig.getAutenticacaoPadrao().getLogin())
                .password(passwordEncoder.encode(applicationConfig.getAutenticacaoPadrao().getSenha()))
                .authorities("ROLE_"+applicationConfig.getAutenticacaoPadrao().getPapel());
    }

}
