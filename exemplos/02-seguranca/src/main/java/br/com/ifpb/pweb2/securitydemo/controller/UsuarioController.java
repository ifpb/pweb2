package br.com.ifpb.pweb2.securitydemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioException;
import br.com.ifpb.pweb2.securitydemo.service.UsuarioService;

@RestController
@RequestMapping(path = "/api")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@PostMapping("/usuario")
	public Usuario adicionarUsuario(@RequestBody  Usuario usuario) throws UsuarioException {
		return usuarioService.salvarUsuario(usuario);		
	}
	
	@PutMapping("/usuario")
	public Usuario editarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.atualizarUsuario(usuario);
	}
	
	@DeleteMapping("/usuario")
	public void excluirUsuario(@RequestBody Usuario usuario) {
		usuarioService.removerUsuario(usuario.getId());
	}

}
