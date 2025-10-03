package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public record NomeDTO(@NotBlank(message = "O nome deve ser informado") String nome) {}
