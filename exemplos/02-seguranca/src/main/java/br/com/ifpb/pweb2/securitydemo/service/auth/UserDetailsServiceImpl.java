package br.com.ifpb.pweb2.securitydemo.service.auth;

import br.com.ifpb.pweb2.securitydemo.config.ApplicationConfig;
import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private ApplicationConfig applicationConfig;

    private PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository, ApplicationConfig applicationConfig, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.applicationConfig = applicationConfig;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals(applicationConfig.getAutenticacaoPadrao().getLogin())){
            return new Usuario(this.applicationConfig.getAutenticacaoPadrao().getLogin(), passwordEncoder.encode(this.applicationConfig.getAutenticacaoPadrao().getSenha()));
        }
        return usuarioRepository.findByLogin(username).orElseThrow( () -> new UsernameNotFoundException(username));
    }
}
