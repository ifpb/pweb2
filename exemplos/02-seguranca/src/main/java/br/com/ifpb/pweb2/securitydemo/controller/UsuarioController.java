/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.pweb2.securitydemo.controller;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioException;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ian
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;
    
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }
    
    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listarUsuarios();
    }
    
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario){
        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuario = usuarioService.salvarUsuario(usuario);
        } catch (UsuarioException ex) {
            return ResponseEntity.badRequest().header("erro", ex.getMessage()).build();
        }
        return ResponseEntity.ok(usuario);
    }
    
    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuario));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity remover(@PathVariable("id") Long id){
        usuarioService.removerUsuario(id);
        return ResponseEntity.accepted().build();
    }
}
