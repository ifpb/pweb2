package br.edu.ifpb.commons.command;

import br.edu.ifpb.commons.domain.Conteudo;
import br.edu.ifpb.commons.domain.Postagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarPostagemCommand {

    public CriarPostagemCommand(Postagem postagem) {
        this.postagem = postagem;
    }

    private Postagem postagem;
}
