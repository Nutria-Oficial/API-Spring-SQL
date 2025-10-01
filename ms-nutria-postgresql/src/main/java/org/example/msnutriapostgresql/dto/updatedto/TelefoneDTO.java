package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.Pattern;

public record TelefoneDTO(
        @Pattern(
                regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
                message = "O número de telefone indicado é inválido"
        )
        String telefone
) {
}
