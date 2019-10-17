package br.com.ifpb.pweb2.securitydemo.controller;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioException;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = this.usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id")
    public ResponseEntity<Object> getUsuario(@PathVariable("id") Long id){
        Usuario usuario = this.usuarioService.recuperarPorId(id).get();
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario){
        try {
            usuario = usuarioService.salvarUsuario(usuario);
        } catch(UsuarioException e) {
            return ResponseEntity.badRequest().header("erro", e.getMessage()).build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping
    public void atualizar(@RequestBody Usuario usuario){
        this.usuarioService.atualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        this.usuarioService.removerUsuario(id);
    }
}
