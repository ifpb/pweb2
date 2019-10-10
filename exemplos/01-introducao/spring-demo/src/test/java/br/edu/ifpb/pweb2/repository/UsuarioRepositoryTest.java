package br.edu.ifpb.pweb2.repository;

import br.edu.ifpb.pweb2.domain.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureTestEntityManager
@DirtiesContext(
        classMode = DirtiesContext.ClassMode.AFTER_CLASS
)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Before
    public void init() {
        Usuario usuario = createUser();
        usuarioRepository.save(usuario);
    }

    @After
    public void close() {
        usuarioRepository.deleteAll();
    }

    @Test
    public void shouldFindByLogin() {
        String login = "diego";
        Optional<Usuario> result = usuarioRepository.findByLogin(login);
        assertTrue(result.isPresent());
        assertEquals(result.get().getLogin(), login);
    }

    private Usuario createUser() {
        return Usuario.builder()
                .cpf("627.380.950-03")
                .email("diego.pessoa@ifpb.edu.br")
                .login("diego")
                .senha("123123")
                .idade(31)
                .nome("Diego Pessoa").build();
    }

}
