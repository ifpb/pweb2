package br.edu.ifpb.participantems.repository;

import br.edu.ifpb.participantems.domain.participante.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

    @Query("SELECT p.nome FROM Participante p")
    List<String> listarNomesParticipantes();
}
