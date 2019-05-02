package br.edu.ifpb.pweb2.springdemo.domain.events;

import org.springframework.context.ApplicationEvent;

public class ConteudoCriado extends ApplicationEvent {
    public ConteudoCriado(Object source) {
        super(source);
    }
}
