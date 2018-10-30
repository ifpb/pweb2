package br.edu.ifpb.pweb2.exemplo1spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    @GetMapping("/teste")
    public String teste() {
        return "Olá, mundo!";
    }

}
