package br.edu.ifpb.pweb2.exemplo1spring.service;

import br.edu.ifpb.pweb2.exemplo1spring.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



}
