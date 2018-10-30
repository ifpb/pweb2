package br.edu.ifpb.pweb2.exemplo1spring.rest;

import br.edu.ifpb.pweb2.exemplo1spring.entities.Usuario;
import br.edu.ifpb.pweb2.exemplo1spring.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario recuperarUsuario(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @GetMapping("/usuarios/por-login")
    public Usuario recuperarUsuarioPorLogin(@RequestParam("login") String login) {
        return usuarioRepository.findByLogin(login).orElse(null);
    }

    @PostMapping("/usuarios")
    public void salvarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuarios")
    public void removerUsuario(@RequestParam("id") Long id) {
        usuarioRepository.deleteById(id);
    }


}
