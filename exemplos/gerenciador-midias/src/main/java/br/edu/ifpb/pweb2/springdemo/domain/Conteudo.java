package br.edu.ifpb.pweb2.springdemo.domain;

import br.edu.ifpb.pweb2.springdemo.domain.events.ConteudoAlterado;
import br.edu.ifpb.pweb2.springdemo.domain.events.ConteudoCriado;
import br.edu.ifpb.pweb2.springdemo.domain.events.ConteudoRemovido;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Conteudo extends AbstractAggregateRoot<Conteudo> {

    public enum ConteudoStatus { PENDENTE, PUBLICADO }

    public enum ConteudoTipo { AUDIO, VIDEO, IMAGEM, DOCUMENTO }

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private ZonedDateTime cadastro;
    private String descricao;
    private ZonedDateTime publicacao;
    private ConteudoStatus status;
    private ConteudoTipo tipo;
    private String usuario;

    @OneToMany(mappedBy = "conteudo")
    private List<Midia> midias;

    public Conteudo conteudoCriado() {
        registerEvent(new ConteudoCriado(this));
        return this;
    }

    public Conteudo conteudoAlterado() {
        registerEvent(new ConteudoAlterado(this));
        return this;
    }

    public Conteudo conteudoRemovido() {
        registerEvent(new ConteudoRemovido(this.getId()));
        return this;
    }

}
