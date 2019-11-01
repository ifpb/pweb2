package br.edu.ifpb.eventosdominio.repository;

import br.edu.ifpb.eventosdominio.domain.participante.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
