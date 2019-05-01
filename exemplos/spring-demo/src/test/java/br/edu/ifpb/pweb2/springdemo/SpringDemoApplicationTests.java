package br.edu.ifpb.pweb2.springdemo;

import br.edu.ifpb.pweb2.springdemo.domain.Papel;
import br.edu.ifpb.pweb2.springdemo.domain.Usuario;
import br.edu.ifpb.pweb2.springdemo.repositories.PapelRepository;
import br.edu.ifpb.pweb2.springdemo.repositories.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PapelRepository papelRepository;

	@Test
	public void contextLoads() {
	}

	public void listarUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		assertTrue(usuarios.size() > 0);
	}

	public void criarUsuario() {

		Usuario usuario = new Usuario(null, "Diego", "diego", "123", null);
		usuarioRepository.save(usuario);

	}

	public void criarPapel() {
		Papel papel = new Papel(null, "Administrador");
		papelRepository.save(papel);
	}

}
