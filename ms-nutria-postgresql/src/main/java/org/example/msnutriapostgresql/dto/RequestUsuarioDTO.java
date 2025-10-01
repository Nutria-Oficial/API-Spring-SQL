package org.example.msnutriapostgresql.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RequestUsuarioDTO(
        @NotBlank(message = "O nome deve ser informado")
        String nome,
        @Email(message = "O email informado é inválido")
        String email,
        @NotBlank(message = "A senha deve ser informada")
        String senha,
        @Pattern(
                regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
                message = "O número de telefone indicado é inválido"
        )
        String telefone,
        String empresa,
        String foto
) {
}
