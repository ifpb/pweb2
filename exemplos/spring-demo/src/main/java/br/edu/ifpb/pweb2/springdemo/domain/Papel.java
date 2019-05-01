package br.edu.ifpb.pweb2.springdemo.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Papel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String nome;

}
