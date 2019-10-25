package br.com.ifpb.pweb2.securitydemo.config;

import br.com.ifpb.pweb2.securitydemo.config.jwt.JwtAuthenticationFilter;
import br.com.ifpb.pweb2.securitydemo.config.jwt.JwtAuthorizationFilter;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    private final SecurityConfig securityConfig;
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationConfig applicationConfig;
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;


    public WebSecurityConfig(SecurityConfig securityConfig, UsuarioService usuarioService, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.securityConfig = securityConfig;
        this.usuarioService = usuarioService;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/publico").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), securityConfig))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), securityConfig)).
                sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .httpBasic()
            .and()
                .csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        if(!usuarioService.isEmpty()){
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }else{
            auth.inMemoryAuthentication()
                    .passwordEncoder(passwordEncoder)
                    .withUser(applicationConfig.getAutenticacaoPadrao().getLogin())
                    .password(passwordEncoder.encode(applicationConfig.getAutenticacaoPadrao().getSenha()))
                    .authorities("ROLE_"+applicationConfig.getAutenticacaoPadrao().getPapel());
        }    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
