package br.edu.ifpb.pweb2.eventoms.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventoException extends Exception {
    public EventoException(String msg) {
        super(msg);
    }
}
