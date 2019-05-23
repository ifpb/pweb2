package br.edu.ifpb.pweb2.springdemo.repositories;

import br.edu.ifpb.commons.domain.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
}
