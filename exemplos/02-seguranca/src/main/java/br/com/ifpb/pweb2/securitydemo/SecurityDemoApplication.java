package br.com.ifpb.pweb2.securitydemo;

import br.com.ifpb.pweb2.securitydemo.util.ListUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Bean
    public ListUtils listUtils() {
        return new ListUtils();
    }

}