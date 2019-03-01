package br.edu.ifpb.lojapweb2.repository;

import br.edu.ifpb.lojapweb2.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    

}
