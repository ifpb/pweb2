package br.edu.ifpb.pweb2.eventoms.repository;

import br.edu.ifpb.pweb2.eventoms.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
