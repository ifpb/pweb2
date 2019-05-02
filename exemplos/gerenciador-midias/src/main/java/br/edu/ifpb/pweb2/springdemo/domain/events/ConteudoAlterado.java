package br.edu.ifpb.pweb2.springdemo.domain.events;

import org.springframework.context.ApplicationEvent;

public class ConteudoAlterado extends ApplicationEvent  {
    public ConteudoAlterado(Object source) {
        super(source);
    }
}
