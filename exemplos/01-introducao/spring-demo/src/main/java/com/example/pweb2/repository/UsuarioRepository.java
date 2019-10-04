package com.example.pweb2.repository;

import com.example.pweb2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findByNomeAndIdade(String nome, Integer idade);

}
