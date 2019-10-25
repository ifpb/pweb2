package br.com.ifpb.pweb2.securitydemo.controller;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioException;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UsuarioController(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/{login}")
    public Usuario recuperarPorLogin(@PathVariable("login") String login) {
        return usuarioService.recuperarPorLogin(login).orElseThrow(RuntimeException::new);
    }



    @GetMapping
    public List<Usuario> listarUsuarios() {

        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) {
        try {
            if (usuario == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getPassword()));

            if (usuarioService.salvarUsuario(usuario) == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            return ResponseEntity.status(HttpStatus.CREATED).build();


        } catch(UsuarioException e) {
            return ResponseEntity.badRequest().header("erro", e.getMessage()).build();
        }
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable("id") Long id) {
        usuarioService.removerUsuario(id);
    }

}
