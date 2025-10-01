package org.example.msnutriapostgresql.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ncdusuario")
    private Integer id;
    @Column(name = "cnmusuario")
    private String nome;
    @Column(name = "cemail")
    private String email;
    @Column(name = "csenha")
    private String senha;
    @Column(name = "ctelefone")
    private String telefone;
    @Column(name = "cempresa")
    private String empresa;
    @Column(name = "cfoto")
    private String foto;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
