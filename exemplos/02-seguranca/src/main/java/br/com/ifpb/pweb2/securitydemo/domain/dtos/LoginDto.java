package br.com.ifpb.pweb2.securitydemo.domain.dtos;

import lombok.Data;

@Data
public class LoginDto {

    private String login;
    private String senha;
}
