package org.example.msnutriapostgresql.dto;

public record ResponseUsuarioDTO(
    String nome, String email, String senha, String telefone, String empresa, String foto) {}
