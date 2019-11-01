package br.edu.ifpb.eventosdominio.domain.participante;

import br.edu.ifpb.eventosdominio.domain.participante.dto.RegistroParticipante;
import br.edu.ifpb.eventosdominio.domain.participante.eventos.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Participante extends AbstractAggregateRoot<Participante> {

    public Participante() {
        super();
    }

    public enum ParticipanteEstado {
        ATIVO, INATIVO, BLOQUEADO
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @Email
    private String email;

    private String instituicao;

    @CPF
    private String cpf;

    private String profissao;

    @Enumerated(EnumType.STRING)
    private ParticipanteEstado estado;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    public Participante alterado() {
        this.registerEvent(new ParticipanteAlterado(this.id, LocalDateTime.now()));
        return this;
    }

    public Participante bloqueado(String razao) {
        this.estado = ParticipanteEstado.BLOQUEADO;
        this.registerEvent(new ParticipanteBloqueado(this.id, LocalDateTime.now(), razao));
        return this;
    }

    @PostPersist
    public void registrado() {
        this.registerEvent(new ParticipanteRegistrado(this.id, LocalDateTime.now()));
    }

    public Participante removido() {
        this.registerEvent(new ParticipanteRemovido(this.id, this.nome, this.email, LocalDateTime.now()));
        return this;
    }

    public Participante ativado() {
        this.estado = ParticipanteEstado.ATIVO;
        this.registerEvent(new ParticipanteAtivado(this.id, LocalDateTime.now()));
        return this;
    }

    public static Participante criar(RegistroParticipante registroParticipante) {
        final Participante participante = new Participante();
        participante.nome = registroParticipante.getNome();
        participante.cpf = registroParticipante.getCpf();
        participante.email = registroParticipante.getEmail();
        participante.instituicao = registroParticipante.getInstituicao();
        participante.profissao = registroParticipante.getProfissao();
        participante.estado = ParticipanteEstado.INATIVO;
        participante.endereco = Endereco.criar(registroParticipante.getLogradouro(),
                registroParticipante.getBairro(), registroParticipante.getCidade(),
                registroParticipante.getEstado(), registroParticipante.getCep());
        participante.contato = Contato.criar(registroParticipante.getTelefoneCelular(),
                        registroParticipante.getTelefoneComercial(),
                        registroParticipante.getTelefoneResidencial());
        return participante;
    }

}
