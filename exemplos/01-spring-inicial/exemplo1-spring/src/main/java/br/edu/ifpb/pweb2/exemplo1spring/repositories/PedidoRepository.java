package br.edu.ifpb.pweb2.exemplo1spring.repositories;

import br.edu.ifpb.pweb2.exemplo1spring.entities.Pedido;
import br.edu.ifpb.pweb2.exemplo1spring.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
