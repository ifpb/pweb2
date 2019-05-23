package br.edu.ifpb.pweb2.springdemo.commandhandlers;

import br.edu.ifpb.commons.command.CriarPostagemCommand;
import br.edu.ifpb.commons.resposta.CommandResponse;
import br.edu.ifpb.pweb2.springdemo.channels.RedeSocialChannels;
import br.edu.ifpb.pweb2.springdemo.domain.Conteudo;
import br.edu.ifpb.pweb2.springdemo.services.PostagemService;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class CommandHandler {


    private final PostagemService postagemService;

    public CommandHandler(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @StreamListener(RedeSocialChannels.REDE_SOCIAL_REQUESTS)
    @SendTo(RedeSocialChannels.SAGA_REPLY)
    public CommandResponse criarPostagemHandler(CriarPostagemCommand criarPostagemCommand) {
        CommandResponse resposta = new CommandResponse(CommandResponse.ResponseStatus.SUCESSO);
        try {
            postagemService.cadastrarPostagem(criarPostagemCommand.getPostagem());
        } catch (Exception e) {
            resposta = new CommandResponse(CommandResponse.ResponseStatus.ERRO);
        }

        return resposta;
    }


}
