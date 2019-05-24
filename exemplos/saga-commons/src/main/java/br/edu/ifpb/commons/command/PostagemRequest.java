package br.edu.ifpb.commons.command;

import br.edu.ifpb.commons.domain.Conteudo;
import br.edu.ifpb.commons.domain.Postagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostagemRequest {

    private Postagem postagem;
    private List<Conteudo> conteudos;

}
