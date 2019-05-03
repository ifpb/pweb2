package br.edu.ifpb.pweb2.springdemo.controllers;

import br.edu.ifpb.pweb2.springdemo.domain.Postagem;
import br.edu.ifpb.pweb2.springdemo.services.PostagemException;
import br.edu.ifpb.pweb2.springdemo.services.PostagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostagemController {

    private final PostagemService postagemService;

    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @PostMapping("/postagem")
    public ResponseEntity<Postagem> criarPostagem(@RequestBody Postagem postagem) {
        ResponseEntity<Postagem> resposta;
        try {
            postagemService.cadastrarPostagem(postagem);
            resposta = ResponseEntity.ok(postagem);
        } catch (PostagemException e) {
            resposta = ResponseEntity.badRequest().header("msg", e.getMessage()).body(null);
        }
        return resposta;
    }

    @GetMapping("/postagem")
    public ResponseEntity<List<Postagem>> listarPostagens() {
        return ResponseEntity.ok().body(postagemService.listarPostagens());
    }

}
