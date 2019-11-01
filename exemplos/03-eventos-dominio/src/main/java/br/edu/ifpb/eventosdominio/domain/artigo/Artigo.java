package br.edu.ifpb.eventosdominio.domain.artigo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Artigo {

    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;
    private String orientador;
    private String autor;
    private String coautores;
    private String modalidade;
    private LocalDateTime dataSubmissao;
    private String urlDownload;

}
