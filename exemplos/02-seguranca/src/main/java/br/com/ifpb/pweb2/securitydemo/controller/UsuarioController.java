package br.com.ifpb.pweb2.securitydemo.controller;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioException;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author raul on 18/10/19
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
