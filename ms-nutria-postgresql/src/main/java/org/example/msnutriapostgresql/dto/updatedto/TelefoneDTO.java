package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.Pattern;

public class TelefoneDTO {
        @Pattern(
                regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
                message = "O número de telefone indicado é inválido")
        String telefone;

        public TelefoneDTO() {
        }

        public TelefoneDTO(String telefone) {
            this.telefone = telefone;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
}
