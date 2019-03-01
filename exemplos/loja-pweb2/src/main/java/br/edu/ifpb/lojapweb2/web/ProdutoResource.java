package br.edu.ifpb.lojapweb2.web;

import br.edu.ifpb.lojapweb2.domain.Produto;
import br.edu.ifpb.lojapweb2.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Api(tags = "Gerenciamento de Produtos")
public class ProdutoResource {

    private final ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @ApiOperation("Listar Produtos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok().body(produtoService.listarProdutos());
    }

    @PostMapping
    @ApiOperation("Criar um novo Produto")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.criarProduto(produto));
    }

}
