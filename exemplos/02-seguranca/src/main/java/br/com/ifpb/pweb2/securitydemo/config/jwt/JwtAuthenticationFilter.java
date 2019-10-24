package br.com.ifpb.pweb2.securitydemo.config.jwt;

import br.com.ifpb.pweb2.securitydemo.config.SecurityConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private final SecurityConfig securityConfig;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, SecurityConfig securityConfig) {
        this.authenticationManager=authenticationManager;
        this.securityConfig = securityConfig;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("usuario");
        String password = request.getParameter("senha");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication authentication) {
        UserDetails user = ((UserDetails) authentication.getPrincipal());

        List<String> roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        String signingKey = securityConfig.getSecret();

        String token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey.getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("type", securityConfig.getTokenType())
                .setIssuer(securityConfig.getIssuer()) //emissor
                .setAudience(securityConfig.getAudience()) //destinatario
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + securityConfig.getExpiration()))
                .claim("roles", roles)
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
    }

}
