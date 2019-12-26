package br.com.ifpb.pweb2.securitydemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/{login}")
    public Usuario recuperarPorLogin(@PathVariable("login") String login) {
        return usuarioService.recuperarPorLogin(login).orElseThrow(RuntimeException::new);
    }

	@GetMapping
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> adicionarUsuario(@RequestBody @Valid Usuario usuario){
		try {
			usuario = usuarioService.salvarUsuario(usuario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().header("erro",e.getMessage()).build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping
	public Usuario editarUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioService.atualizarUsuario(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void excluirUsuario(@PathVariable("id") Long id) {
		usuarioService.removerUsuario(id);
	}

}
