package br.edu.ifpb.apigateway;

import br.edu.ifpb.apigateway.canais.SagaChannels;
import br.edu.ifpb.commons.command.CriarConteudosCommand;
import br.edu.ifpb.commons.command.CriarPostagemCommand;
import br.edu.ifpb.commons.command.PostagemRequest;
import br.edu.ifpb.commons.domain.Conteudo;
import br.edu.ifpb.commons.domain.Postagem;
import br.edu.ifpb.commons.resposta.CommandResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CriarPostagemSaga {

    private final SagaChannels sagaChannels;

    public CriarPostagemSaga(SagaChannels sagaChannels) {
        this.sagaChannels = sagaChannels;
    }

    //Etapa 1
    public void criarPostagem(Postagem postagem, List<Conteudo> conteudos) {
        CriarPostagemCommand postagemCommand = new CriarPostagemCommand(new PostagemRequest(postagem, conteudos));
        sagaChannels.redeSocialRequests().send(new GenericMessage<>(postagemCommand));
    }

    //Etapa 2
    public void criarConteudos(List<Conteudo> conteudos) {
        CriarConteudosCommand conteudosCommand = new CriarConteudosCommand(conteudos);
        sagaChannels.conteudoRequests().send(new GenericMessage<>(conteudosCommand));
    }

    //Respostas
    @StreamListener(value = SagaChannels.RESPOSTAS)
    public void postagemCriada(CommandResponse resposta) {
        if (resposta.getCommand() instanceof CriarPostagemCommand) {
            if (resposta.getStatus().equals(CommandResponse.ResponseStatus.SUCESSO)) {
                this.criarConteudos(((CriarPostagemCommand) resposta.getCommand()).getPostagemRequest().getConteudos());
            } else {
                log.error("Falha ao criar postagem");
            }
        } else if (resposta.getCommand() instanceof CriarConteudosCommand) {
            if (resposta.getStatus().equals(CommandResponse.ResponseStatus.SUCESSO)) {
                //proximo
            } else {
                //compensar - desfazer
            }
        }
    }

}
