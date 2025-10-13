package org.example.msnutriapostgresql.dto;

public record ResponseAdminDTO(
        String nome,
        String email,
        String telefone,
        String cargo,
        String foto,
        Integer idade
) {
}
