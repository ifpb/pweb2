package com.example.pweb2.service;

import com.example.pweb2.domain.Usuario;
import com.example.pweb2.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) throws UsuarioException {
        Usuario usuarioCriado = null;
        try {
            usuarioCriado = this.usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new UsuarioException("Login já cadastrado");
        }
        return usuarioCriado;
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
        return this.usuarioRepository.save(usuario);
    }
}
