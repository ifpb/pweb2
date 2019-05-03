package br.edu.ifpb.pweb2.springdemo.repositories;

import br.edu.ifpb.pweb2.springdemo.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
