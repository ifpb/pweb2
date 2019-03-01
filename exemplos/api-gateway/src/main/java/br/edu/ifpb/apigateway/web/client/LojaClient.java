package br.edu.ifpb.apigateway.web.client;

import br.edu.ifpb.lojapweb2.domain.domain.Cliente;
import br.edu.ifpb.lojapweb2.domain.domain.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "loja", path = "/api")
public interface LojaClient {

    @GetMapping("/clientes")
    ResponseEntity<List<Cliente>> listarClientes();

    @PostMapping("/clientes")
    ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente);

    @GetMapping("/clientes/id/{id}")
    ResponseEntity<Cliente> recuperarCliente(@PathVariable("id") Long id);

    @GetMapping("/produtos")
    ResponseEntity<List<Produto>> listarProdutos();

    @PostMapping("/produtos")
    ResponseEntity<Produto> criarProduto(@RequestBody Produto produto);

}