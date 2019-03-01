package br.edu.ifpb.lojapweb2.repository;

import br.edu.ifpb.lojapweb2.domain.Categoria;
import br.edu.ifpb.lojapweb2.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    

}
