package br.com.ifpb.pweb2.securitydemo.service;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Usuario salvarUsuario(Usuario usuario) throws UsuarioException {
        Usuario usuarioCriado = null;
        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioCriado = this.usuarioRepository.save(usuario);
            salvarLog();
        } catch (DataIntegrityViolationException e) {
            throw new UsuarioException("Login já cadastrado");
        }
        return usuarioCriado;
    }

    public void salvarLog() {
        log.info("Usuário salvo");
    }

    public Optional<Usuario> recuperarPorId(Long id){
        return this.usuarioRepository.findById(id);
    }

    public void removerUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> recuperarPorLogin(String login) {
        return this.usuarioRepository.findByLogin(login);
    }

    public Optional<Usuario> recuperarPorNomeEIdade(String nome, Integer idade) {
        return this.usuarioRepository.findByNomeAndIdade(nome, idade);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
    	usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        return this.usuarioRepository.save(usuario);
    }

    public boolean IsVazio(){
        return usuarioRepository.findAll().isEmpty();
    }

}
