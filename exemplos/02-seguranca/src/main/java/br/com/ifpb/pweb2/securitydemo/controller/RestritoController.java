package br.com.ifpb.pweb2.securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestritoController {

    @GetMapping("/livre")
    public String exibirMensagemQualquer() {
        return "Olá, qualquer papel tem acesso";
    }

    @GetMapping("/restrito")
    @PreAuthorize("hasRole('ADMIN')")
    public String exibirMensagemAdmin() {
        return "Olá, meu acesso é retrito a admin";
    }

    @GetMapping("/restrito2")
    @PreAuthorize("hasRole('OPERATOR')")
    public String exibirMensagemOperador() {
        return "Olá, meu acesso é retrito a operador";
    }

}
