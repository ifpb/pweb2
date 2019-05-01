package br.edu.ifpb.pweb2.springdemo.services;

import br.edu.ifpb.pweb2.springdemo.domain.Usuario;
import br.edu.ifpb.pweb2.springdemo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        //Regras de negócio
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
