package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public class NomeDTO{
    @NotBlank(message = "O nome deve ser informado") String nome;

    public NomeDTO() {
    }

    public NomeDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
