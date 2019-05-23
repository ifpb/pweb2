package br.edu.ifpb.pweb2.springdemo.commandhandlers;

import br.edu.ifpb.commons.command.CriarConteudosCommand;
import br.edu.ifpb.commons.domain.Conteudo;
import br.edu.ifpb.commons.resposta.CommandResponse;
import br.edu.ifpb.pweb2.springdemo.channels.GerenciadorMidiasChannels;
import br.edu.ifpb.pweb2.springdemo.services.ConteudoService;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class CommandHandler {

    private final ConteudoService conteudoService;

    public CommandHandler(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @StreamListener(GerenciadorMidiasChannels.CONTEUDO_SERVICE_REQUESTS)
    @SendTo(GerenciadorMidiasChannels.SAGA_REPLY)
    public CommandResponse criarConteudosHandler(CriarConteudosCommand criarConteudosCommand) {
        CommandResponse resposta = new CommandResponse(CommandResponse.ResponseStatus.SUCESSO);
        try {
            for (Conteudo conteudo : criarConteudosCommand.getConteudos()) {
                conteudoService.criarConteudo(conteudo);
            }
        } catch (Exception e) {
            resposta = new CommandResponse(CommandResponse.ResponseStatus.ERRO);
        }

        return resposta;
    }

}
