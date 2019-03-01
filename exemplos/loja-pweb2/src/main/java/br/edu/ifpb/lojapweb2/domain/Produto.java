package br.edu.ifpb.lojapweb2.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Double preco;

    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Categoria> categoria;

}
