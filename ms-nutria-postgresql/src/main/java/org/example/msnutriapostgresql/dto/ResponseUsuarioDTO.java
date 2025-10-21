package org.example.msnutriapostgresql.dto;

public record ResponseUsuarioDTO(
    Integer id,
    String nome,
    String email,
    String senha,
    String telefone,
    String empresa,
    String foto) {}
