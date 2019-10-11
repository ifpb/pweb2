package br.com.ifpb.pweb2.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico")
public class PublicoController {

    @GetMapping
    public String exibirMensagem() {
        return "Olá, meu acesso é público";
    }

}
