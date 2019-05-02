package br.edu.ifpb.pweb2.springdemo.repositories;

import br.edu.ifpb.pweb2.springdemo.domain.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
}
