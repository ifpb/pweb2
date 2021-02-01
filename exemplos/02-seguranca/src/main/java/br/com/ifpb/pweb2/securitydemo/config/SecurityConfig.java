package br.com.ifpb.pweb2.securitydemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="security")
@Data
public class SecurityConfig {
    private String authLoginUrl;
    private String tokenType;
    private String secret;
    private String issuer;
    private String audience;
    private Long expiration;

}
