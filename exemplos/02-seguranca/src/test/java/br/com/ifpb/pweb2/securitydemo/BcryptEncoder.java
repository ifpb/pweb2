package br.com.ifpb.pweb2.securitydemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class BcryptEncoder {

    private  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void gerarSenha() {
        String senha = "123";
        String hash = this.passwordEncoder.encode(senha);
        log.info("SENHA = ");
        log.info(hash);
    }

}
