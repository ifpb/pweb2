package br.edu.ifpb.commons.resposta;

public interface ComandoResposta<T> {

    CommandResponse.ResponseStatus getStatus();

    T getComando();

}
