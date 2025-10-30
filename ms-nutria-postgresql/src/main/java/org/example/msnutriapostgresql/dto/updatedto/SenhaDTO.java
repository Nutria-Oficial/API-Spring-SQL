package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public class SenhaDTO {
    @NotBlank(message = "A senha antiga deve ser informada") String senhaAntiga;
    @NotBlank(message = "A senha nova deve ser informada") String senhaNova;

    public SenhaDTO() {
    }

    public SenhaDTO(String senhaAntiga, String senhaNova) {
        this.senhaAntiga = senhaAntiga;
        this.senhaNova = senhaNova;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }
}
