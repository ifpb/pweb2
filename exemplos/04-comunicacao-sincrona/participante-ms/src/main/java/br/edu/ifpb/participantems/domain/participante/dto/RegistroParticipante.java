package br.edu.ifpb.participantems.domain.participante.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class RegistroParticipante {

    @NotBlank
    @Min(20)
    @Max(100)
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String instituicao;

    @CPF
    @NotBlank
    private String cpf;

    @NotBlank
    private String profissao;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    private String telefoneComercial;

    private String telefoneResidencial;

    private String telefoneCelular;

}
