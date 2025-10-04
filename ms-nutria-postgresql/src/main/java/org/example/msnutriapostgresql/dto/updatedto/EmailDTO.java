package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.Email;

public record EmailDTO(@Email(message = "O email informado é inválido") String email) {}
