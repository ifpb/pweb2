package br.edu.ifpb.pweb2.springdemo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 50)
    private String login;

    @Column(length = 64)
    private String senha;

    @ManyToMany
    private List<Papel> papeis;

}
