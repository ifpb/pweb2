package br.edu.ifpb.pweb2.controller;

import br.edu.ifpb.pweb2.domain.Usuario;
import br.edu.ifpb.pweb2.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsuarioControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Before
    public void setup() {
       this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void recuperarPorLoginTest() throws Exception {
        usuarioRepository.save(createUser());
        this.mockMvc.perform(get("/usuarios/diego"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.login").value("diego"))
                .andExpect(jsonPath("$.email").value("diego.pessoa@ifpb.edu.br"))
                .andExpect(jsonPath("$.cpf").value("627.380.950-03"))
                .andExpect(jsonPath("$.idade").value(31))
                .andExpect(jsonPath("$.nome").value("Diego Pessoa"))
                .andReturn();
    }

    @Test
    public void criarUsuarioTest() throws Exception {
        this.mockMvc.perform(post("/usuarios")
                .contentType("application/json")
                .content("{\n" +
                        "    \"nome\": \"Mailson\",\n" +
                        "    \"idade\": 20,\n" +
                        "    \"cpf\": \"937.984.884-60\",\n" +
                        "    \"login\": \"mailson\",\n" +
                        "    \"email\": \"mailson@gmail.com\",\n" +
                        "    \"senha\": \"123\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.cpf").value("937.984.884-60"))
                .andExpect(jsonPath("$.login").value("mailson"));
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
