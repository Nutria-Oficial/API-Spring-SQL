package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public record SenhaDTO(
    @NotBlank(message = "A senha antiga deve ser informada") String senhaAntiga,
    @NotBlank(message = "A senha nova deve ser informada") String senhaNova) {}
