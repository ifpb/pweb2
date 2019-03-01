package br.edu.ifpb.lojapweb2.service;

import br.edu.ifpb.lojapweb2.domain.Cliente;
import br.edu.ifpb.lojapweb2.domain.Produto;
import br.edu.ifpb.lojapweb2.repository.ClienteRepository;
import br.edu.ifpb.lojapweb2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository produtoRepository) {
        this.clienteRepository = produtoRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> recuperar(Long id) {
        return clienteRepository.findById(id);
    }

    public void removerProduto(Long produtoId) {
        clienteRepository.deleteById(produtoId);
    }

}
