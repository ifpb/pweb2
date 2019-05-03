package br.edu.ifpb.pweb2.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RedeSocialBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedeSocialBackendApplication.class, args);
	}

}
