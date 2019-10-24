package br.com.ifpb.pweb2.securitydemo.config.jwt;

import br.com.ifpb.pweb2.securitydemo.config.SecurityConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class JwtUtil {

    private final SecurityConfig securityConfig;
    private final String signingKey;

    public JwtUtil(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
        signingKey = securityConfig.getSecret();
    }

    public String generateToken(Authentication authentication) {
        UserDetails user = ((UserDetails) authentication.getPrincipal());

        List<String> roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey.getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("type", securityConfig.getTokenType())
                .setIssuer(securityConfig.getIssuer()) //emissor
                .setAudience(securityConfig.getAudience()) //destinatario
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + securityConfig.getExpiration()))
                .claim("roles", roles)
                .compact();
    }
}
