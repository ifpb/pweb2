package br.edu.ifpb.pweb2.springdemo.services;

import br.edu.ifpb.pweb2.springdemo.domain.Conteudo;
import br.edu.ifpb.pweb2.springdemo.domain.events.ConteudoCriado;
import br.edu.ifpb.pweb2.springdemo.domain.events.ConteudoRemovido;
import br.edu.ifpb.pweb2.springdemo.repositories.ConteudoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConteudoService {

    private final ConteudoRepository conteudoRepository;

    private final ApplicationEventPublisher eventPublisher;

    public ConteudoService(ConteudoRepository conteudoRepository, ApplicationEventPublisher eventPublisher) {
        this.conteudoRepository = conteudoRepository;
        this.eventPublisher = eventPublisher;
    }

    public void criarConteudoComPublicacaoManual(Conteudo conteudo) {
        conteudoRepository.save(conteudo);

        //disparar o evento de criação de conteúdo
        eventPublisher.publishEvent(new ConteudoCriado(conteudo));
    }

    public Conteudo criarConteudo(Conteudo conteudo) {
        return conteudoRepository.save(conteudo.conteudoCriado());
    }

    public void removerConteudo(Long conteudoId) {
        conteudoRepository.deleteById(conteudoId);
    }

    public List<Conteudo> listarConteudos() {
        return conteudoRepository.findAll();
    }

    public Optional<Conteudo> recuperarPorId(Long id) {
        return conteudoRepository.findById(id);
    }

    @EventListener
    public void conteudoCriadoListener(ConteudoCriado conteudoCriado) {
        System.out.println(String.format("Conteúdo %s criado - evento recebido", ((Conteudo)conteudoCriado.getSource()).getTitulo()));
    }

    @EventListener
    public void conteudoRemovidoListener(ConteudoRemovido conteudoRemovido) {
        System.out.println(String.format("Conteúdo do ID %d removido",conteudoRemovido.getIdConteudo()));
    }

}
