package br.edu.ifpb.lojapweb2.service;

import br.edu.ifpb.lojapweb2.domain.Produto;
import br.edu.ifpb.lojapweb2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> recuperarProduto(Long id) {
        return produtoRepository.findById(id);
    }

    public void removerProduto(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }

}
