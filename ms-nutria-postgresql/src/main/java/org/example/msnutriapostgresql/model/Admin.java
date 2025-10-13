package org.example.msnutriapostgresql.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ncdadmin")
  private Integer id;

  @Column(name = "cnmadmin")
  private String nome;

  @Column(name = "cemail")
  private String email;

  @Column(name = "csenha")
  private String senha;

  @Column(name = "ctelefone")
  private String telefone;

  @Column(name = "dnascimento")
  private LocalDate dataNascimento;

  @Column(name = "ccargo")
  private String cargo;

  @Column(name = "cfoto")
  private String foto;

  // getters e setters

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

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }
}
