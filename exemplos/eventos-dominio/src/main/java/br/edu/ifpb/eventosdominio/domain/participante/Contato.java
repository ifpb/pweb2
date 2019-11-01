package br.edu.ifpb.eventosdominio.domain.participante;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Contato {

    @Id
    @GeneratedValue
    private Integer id;

    private String telefoneComercial;
    private String telefoneResidencial;
    private String telefoneCelular;

    public static Contato criar(String telefoneComercial, String telefoneResidencial, String telefoneCelular) {
        final Contato contato = new Contato();
        contato.telefoneCelular = telefoneCelular;
        contato.telefoneResidencial = telefoneResidencial;
        contato.telefoneComercial = telefoneComercial;
        return contato;
    }

}
