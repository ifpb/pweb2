package br.edu.ifpb.pweb2.springdemo.controllers;

import br.edu.ifpb.pweb2.springdemo.domain.Usuario;
import br.edu.ifpb.pweb2.springdemo.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void removerUsuario(@PathVariable("id") Long id) {
        usuarioService.removerUsuario(id);
    }

}
