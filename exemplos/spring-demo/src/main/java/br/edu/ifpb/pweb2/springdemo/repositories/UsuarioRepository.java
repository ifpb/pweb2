package br.edu.ifpb.pweb2.springdemo.repositories;

import br.edu.ifpb.pweb2.springdemo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
