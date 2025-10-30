package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public class FotoDTO{
    @NotBlank(message = "A url da foto deve ser informada") String foto;

    public FotoDTO() {
    }

    public FotoDTO(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
