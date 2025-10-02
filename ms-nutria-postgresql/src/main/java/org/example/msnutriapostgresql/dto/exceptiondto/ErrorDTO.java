package org.example.msnutriapostgresql.dto.exceptiondto;


public record ErrorDTO(
        int status,
        String error,
        String message
) {
}
