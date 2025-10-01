package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public record FotoDTO(
        @NotBlank(message = "A url da foto deve ser informada")
        String foto
) {
}
