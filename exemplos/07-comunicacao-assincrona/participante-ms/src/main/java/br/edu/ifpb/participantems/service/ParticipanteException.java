package br.edu.ifpb.participantems.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParticipanteException extends Exception {

    public ParticipanteException(String msg) {
        super(msg);
    }

}
