package com.saraiva.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarLivroDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        String descricao,
        String capaUrl,
        @NotBlank(message = "Autor é obrigatório")
        String autor,

        @NotNull(message = "Quantidade é obrigatorio")
        @Min(value = 0, message = "Quantidade não pode ser negativa")
        Integer quantidade,
        Integer anoLancamento
) {
}
