package br.edu.ifpb.lojapweb2.web;

import br.edu.ifpb.lojapweb2.domain.Cliente;
import br.edu.ifpb.lojapweb2.domain.Produto;
import br.edu.ifpb.lojapweb2.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@Api(tags = "Gerenciamento de Clientes")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @ApiOperation("Listar Clientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok().body(clienteService.listar());
    }

    @PostMapping
    @ApiOperation("Criar um novo Cliente")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.criar(cliente));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> recuperarCliente(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = clienteService.recuperar(id);

        if (!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente.get());
    }

}
