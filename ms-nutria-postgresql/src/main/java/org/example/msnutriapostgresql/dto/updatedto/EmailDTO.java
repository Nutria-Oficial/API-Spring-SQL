package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.Email;

public class EmailDTO{
    @Email(message = "O email informado é inválido") String email;

    public EmailDTO() {
    }

    public EmailDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
