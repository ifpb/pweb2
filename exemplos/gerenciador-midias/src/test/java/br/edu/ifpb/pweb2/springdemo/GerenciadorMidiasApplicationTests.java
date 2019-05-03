package br.edu.ifpb.pweb2.springdemo;

import br.edu.ifpb.pweb2.springdemo.domain.Conteudo;
import br.edu.ifpb.pweb2.springdemo.repositories.ConteudoRepository;
import br.edu.ifpb.pweb2.springdemo.services.ConteudoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GerenciadorMidiasApplicationTests {

	@Autowired
	private ConteudoRepository conteudoRepository;

	@Autowired
	private ConteudoService conteudoService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void criarConteudo() {
		Conteudo conteudo = new Conteudo();
		conteudo.setTitulo("Conteudo teste");
		conteudo.setDescricao("Descricao do conteudo teste");
		conteudo.setTipo(Conteudo.ConteudoTipo.VIDEO);
		conteudo.setCadastro(ZonedDateTime.now());
		conteudo.setUsuario("diego");
		conteudoRepository.save(conteudo);
	}

	@Test
	public void criarConteudoEvento1() {
		Conteudo conteudo = new Conteudo();
		conteudo.setTitulo("Conteudo teste 5");
		conteudo.setDescricao("Descricao do conteudo teste 5");
		conteudo.setTipo(Conteudo.ConteudoTipo.AUDIO);
		conteudo.setCadastro(ZonedDateTime.now());
		conteudo.setUsuario("diego");
		conteudoService.criarConteudo(conteudo);
	}

	@Test
	public void removerConteudo() {
		conteudoService.removerConteudo(2l);
	}

}
