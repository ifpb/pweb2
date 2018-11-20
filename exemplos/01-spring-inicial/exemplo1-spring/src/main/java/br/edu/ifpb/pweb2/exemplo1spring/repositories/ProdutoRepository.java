package br.edu.ifpb.pweb2.exemplo1spring.repositories;

import br.edu.ifpb.pweb2.exemplo1spring.entities.Pedido;
import br.edu.ifpb.pweb2.exemplo1spring.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
