package br.edu.ifpb.pweb2.springdemo.client;

import br.edu.ifpb.commons.domain.Conteudo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gerenciador-midias")
@Component
public interface GerenciadorMidiasClient {

    @GetMapping("/conteudos/{id}")
    ResponseEntity<Conteudo> recuperarConteudo(@PathVariable("id") Long id);

    @GetMapping("/conteudos")
    List<Conteudo> listarConteudos();

    @PostMapping("/conteudos")
    Conteudo criarConteudo(@RequestBody Conteudo conteudo);

    @DeleteMapping("/conteudos/{id}")
    void removerConteudo(@PathVariable("id") Long id);

}
