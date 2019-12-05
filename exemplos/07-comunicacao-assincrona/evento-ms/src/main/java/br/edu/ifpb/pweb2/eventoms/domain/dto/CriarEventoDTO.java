package br.edu.ifpb.pweb2.eventoms.domain.dto;

import br.edu.ifpb.pweb2.eventoms.domain.Evento;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CriarEventoDTO {

    @NotBlank
    private String nome;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate data;

    @NotNull
    private Evento.TipoEvento tipo;

    private String descricao;

}
