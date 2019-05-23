package br.edu.ifpb.pweb2.springdemo.services;

import br.edu.ifpb.commons.domain.Conteudo;
import br.edu.ifpb.commons.domain.Postagem;
import br.edu.ifpb.messageproducercloudstream.canais.EventosChannels;
import br.edu.ifpb.messageproducercloudstream.evento.Evento;
import br.edu.ifpb.pweb2.springdemo.client.GerenciadorMidiasClient;
import br.edu.ifpb.pweb2.springdemo.repositories.PostagemRepository;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostagemService {

    private final PostagemRepository postagemRepository;

    private final GerenciadorMidiasClient gerenciadorMidiasClient;

    public PostagemService(PostagemRepository postagemRepository, GerenciadorMidiasClient gerenciadorMidiasClient) {
        this.postagemRepository = postagemRepository;
        this.gerenciadorMidiasClient = gerenciadorMidiasClient;
    }

    public Postagem cadastrarPostagem(Postagem postagem) throws PostagemException {

        for (Long conteudoId : postagem.getConteudos()) {
            try {
                ResponseEntity<Conteudo> resposta = gerenciadorMidiasClient.recuperarConteudo(conteudoId);
                log.info(String.format("Conteúdo %s verificado e existe", resposta.getBody().getTitulo()));
            } catch (FeignException ex) {
                ex.printStackTrace();
                throw new PostagemException("Foi passado um conteúdo não existente");
            }
        }
        
        return postagemRepository.save(postagem);
    }

    public List<Postagem> listarPostagens() {
        return postagemRepository.findAll();
    }


    @StreamListener(EventosChannels.ENTRADA)
    @SendTo(EventosChannels.SAIDA)
    public String tratarEvento(Evento evento) {
        if (evento.getNome().equals("ConteudoRemovido")) {
            log.info("Recebendo evento de remoção do conteúdo id ="+evento.getObjetoID());
            List<Postagem> postagens = postagemRepository.findAll();
            for (Postagem postagem : postagens) {
                postagem.setConteudos(postagem.getConteudos().stream().filter( cId -> !cId.equals(evento.getObjetoID())).collect(Collectors.toList()));
                postagemRepository.save(postagem);
            }
        }
        return "{ 'resultado': 'sucesso' }";
    }

}
