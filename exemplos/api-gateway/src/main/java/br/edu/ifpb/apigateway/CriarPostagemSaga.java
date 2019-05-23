package br.edu.ifpb.apigateway;

import br.edu.ifpb.apigateway.canais.SagaChannels;
import br.edu.ifpb.commons.command.CriarConteudosCommand;
import br.edu.ifpb.commons.command.CriarPostagemCommand;
import br.edu.ifpb.commons.domain.Conteudo;
import br.edu.ifpb.commons.domain.Postagem;
import br.edu.ifpb.commons.resposta.CommandResponse;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriarPostagemSaga {

    private final SagaChannels sagaChannels;

    public CriarPostagemSaga(SagaChannels sagaChannels) {
        this.sagaChannels = sagaChannels;
    }

    //Etapa 1
    public void criarPostagem(Postagem postagem, List<Conteudo> conteudos) {
        CriarPostagemCommand postagemCommand = new CriarPostagemCommand(postagem);
        sagaChannels.redeSocialRequests().send(new GenericMessage<>(postagemCommand));
    }

    //Etapa 2
    @StreamListener(SagaChannels.RESPOSTAS)
    public void postagemCriada(CommandResponse resposta) {
        if (resposta.getStatus().equals(CommandResponse.ResponseStatus.SUCESSO)) {
            this.criarConteudos(conteudos);
        } else {
            //compensação
        }
    }

    public void criarConteudos(List<Conteudo> conteudos) {
        CriarConteudosCommand conteudosCommand = new CriarConteudosCommand(conteudos);
        sagaChannels.conteudoRequests().send(new GenericMessage<>(conteudosCommand));
    }

    @StreamListener(SagaChannels.RESPOSTAS)
    public void conteudoCriado(CommandResponse resposta) {
        if (resposta.getStatus().equals(CommandResponse.ResponseStatus.SUCESSO)) {
            //próximo passo
        } else {
            //compensação
        }
    }

}
