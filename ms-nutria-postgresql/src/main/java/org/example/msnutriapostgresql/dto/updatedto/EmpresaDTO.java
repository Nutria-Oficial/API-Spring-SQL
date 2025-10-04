package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public record EmpresaDTO(@NotBlank(message = "O nome da foto deve ser informada") String empresa) {}
