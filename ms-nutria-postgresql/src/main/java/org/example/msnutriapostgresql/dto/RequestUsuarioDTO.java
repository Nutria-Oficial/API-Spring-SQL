package org.example.msnutriapostgresql.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RequestUsuarioDTO {
        @NotBlank(message = "O nome deve ser informado") String nome;
        @Email(message = "O email informado é inválido") String email;
        @NotBlank(message = "A senha deve ser informada") String senha;
        @Pattern(
                regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
                message = "O número de telefone indicado é inválido")
        String telefone;
        String empresa;
        String foto;

        public RequestUsuarioDTO() {
        }

        public RequestUsuarioDTO(String nome, String email, String senha, String telefone, String empresa, String foto) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.telefone = telefone;
            this.empresa = empresa;
            this.foto = foto;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
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

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmpresa() {
            return empresa;
        }

        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }
}
