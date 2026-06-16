package com.saraiva.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    private String capaUrl;
    @Column(nullable = false)
    private String autor;
    private String descricao;

    @Column(nullable = false)
    private Integer quantidade;
    private Integer anoLancamento;

    @Column(nullable = false)
    private Boolean disponivel;
}


