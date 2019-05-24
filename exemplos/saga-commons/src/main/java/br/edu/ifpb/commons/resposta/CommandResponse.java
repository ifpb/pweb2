package br.edu.ifpb.commons.resposta;


import br.edu.ifpb.commons.command.Comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandResponse {

    public enum ResponseStatus { SUCESSO, ERRO }

    private ResponseStatus status;

    private Comando command;

}
