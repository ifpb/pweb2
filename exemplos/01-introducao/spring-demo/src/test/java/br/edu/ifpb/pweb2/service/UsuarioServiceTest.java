package br.edu.ifpb.pweb2.service;

import br.edu.ifpb.pweb2.domain.Usuario;
import br.edu.ifpb.pweb2.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.internal.verification.api.InOrderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

    @InjectMocks
    @Spy
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void recuperarPorLoginTest() {
        Usuario usuario = createUser();
        when(usuarioRepository.findByLogin(anyString())).thenReturn(Optional.of(usuario));

        String login = "diego";
        Optional<Usuario> resultado = usuarioService.recuperarPorLogin(login);
        assertTrue(resultado.isPresent());
        assertEquals(resultado.get().getLogin(), login);
    }

    @Test
    public void salvarUsuarioTest() throws UsuarioException {

        Usuario usuario = createUser();
        usuario.setId(1L);

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioCriado = usuarioService.salvarUsuario(usuario);

        InOrder inOrder = Mockito.inOrder(usuarioRepository, usuarioService);
        inOrder.verify(usuarioRepository).save(eq(usuario));
        inOrder.verify(usuarioService).salvarLog();

        assertNotNull(usuarioCriado);
        assertNotNull(usuarioCriado.getId());

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
