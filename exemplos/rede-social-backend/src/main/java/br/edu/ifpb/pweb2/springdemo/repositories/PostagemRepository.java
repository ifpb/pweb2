package br.edu.ifpb.pweb2.springdemo.repositories;

import br.edu.ifpb.commons.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
