package org.example.lojajpa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o nome do produto")
    private String nome;

    @NotNull(message = "Preencha um preço para o produto!")
    @Positive(message = "Preço precisa positivo!")
    private Double preco;
}
