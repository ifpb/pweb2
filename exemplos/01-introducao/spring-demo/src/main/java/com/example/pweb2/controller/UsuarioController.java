package com.example.pweb2.controller;

import com.example.pweb2.domain.Usuario;
import com.example.pweb2.service.UsuarioException;
import com.example.pweb2.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) {
        try {
            usuario = usuarioService.salvarUsuario(usuario);
        } catch(UsuarioException e) {
            return ResponseEntity.badRequest().header("erro", e.getMessage()).build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/usuarios")
    public Usuario atualizarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void removerUsuario(@PathVariable("id") Long id) {
        usuarioService.removerUsuario(id);
    }

}
