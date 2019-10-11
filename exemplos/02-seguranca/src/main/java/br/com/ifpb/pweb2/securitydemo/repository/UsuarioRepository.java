package br.com.ifpb.pweb2.securitydemo.repository;

import br.com.ifpb.pweb2.securitydemo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findByNomeAndIdade(String nome, Integer idade);

}
