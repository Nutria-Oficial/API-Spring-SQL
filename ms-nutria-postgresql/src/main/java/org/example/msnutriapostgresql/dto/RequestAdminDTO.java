package org.example.msnutriapostgresql.dto;

public class RequestAdminDTO{
    String email;
    String senha;

    public RequestAdminDTO() {
    }

    public RequestAdminDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
