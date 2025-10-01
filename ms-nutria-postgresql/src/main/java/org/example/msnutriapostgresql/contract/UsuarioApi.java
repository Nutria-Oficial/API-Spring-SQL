package org.example.msnutriapostgresql.contract;

import jakarta.validation.Valid;
import org.example.msnutriapostgresql.dto.RequestUsuarioDTO;
import org.example.msnutriapostgresql.dto.ResponseUsuarioDTO;
import org.example.msnutriapostgresql.dto.updatedto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/usuarios")
public interface UsuarioApi {
    @PostMapping
    ResponseEntity<ResponseUsuarioDTO> cadastrarUsuario(@Valid @RequestBody RequestUsuarioDTO requestUsuarioDTO);

    @GetMapping("/{email}")
    ResponseEntity<ResponseUsuarioDTO> buscarUsuario(@PathVariable String email);
    @PatchMapping("/{id}/nome")
    ResponseEntity<ResponseUsuarioDTO> atualizarNomeUsuario(@PathVariable Integer id, @Valid @RequestBody NomeDTO nomeDTO);
    @PatchMapping("/{id}/email")
    ResponseEntity<ResponseUsuarioDTO> atualizarEmailUsuario(@PathVariable Integer id, @Valid @RequestBody EmailDTO emailDTO);

    @PatchMapping("/{id}/telefone")
    ResponseEntity<ResponseUsuarioDTO> atualizarTelefoneUsuario(@PathVariable Integer id, @Valid @RequestBody TelefoneDTO telefoneDTO);

    @PatchMapping("/{id}/senha")
    ResponseEntity<ResponseUsuarioDTO> atualizarSenhaUsuario(@PathVariable Integer id, @Valid @RequestBody SenhaDTO senhaDTO);

    @PatchMapping("/{id}/empresa")
    ResponseEntity<ResponseUsuarioDTO> atualizarEmpresaUsuario(@PathVariable Integer id, @Valid @RequestBody EmpresaDTO empresaDTO);

    @PatchMapping("/{id}/foto")
    ResponseEntity<ResponseUsuarioDTO> atualizarFotoUsuario(@PathVariable Integer id, @Valid @RequestBody FotoDTO fotoDTO);
}
