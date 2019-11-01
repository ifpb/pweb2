package br.edu.ifpb.eventosdominio.domain.participante;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.validation.constraints.Email;

@Entity
@Getter
public class Endereco {

    @Id
    @GeneratedValue
    private Integer id;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    public static Endereco criar(String logradouro, String bairro, String cidade, String estado, String cep) {
        final Endereco endereco = new Endereco();
        endereco.logradouro = logradouro;
        endereco.bairro = bairro;
        endereco.cidade = cidade;
        endereco.estado = estado;
        endereco.cep = cep;
        return endereco;
    }

}
