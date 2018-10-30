package br.edu.ifpb.pweb2.exemplo1spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Exemplo1SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exemplo1SpringApplication.class, args);
    }
}
