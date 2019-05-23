package br.edu.ifpb.apigateway;

import br.edu.ifpb.apigateway.canais.SagaChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableBinding(SagaChannels.class)
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
