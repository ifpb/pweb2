package br.edu.ifpb.participantems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ParticipanteMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParticipanteMSApplication.class, args);
    }

}
