package org.example.msnutriapostgresql.controller;

import jakarta.validation.Valid;
import org.example.msnutriapostgresql.contract.UsuarioApi;
import org.example.msnutriapostgresql.dto.RequestUsuarioDTO;
import org.example.msnutriapostgresql.dto.ResponseUsuarioDTO;
import org.example.msnutriapostgresql.dto.updatedto.*;
import org.example.msnutriapostgresql.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioApi {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> cadastrarUsuario(@Valid @RequestBody RequestUsuarioDTO requestUsuarioDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.cadastrarUsuario(requestUsuarioDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.CREATED);
    }
    @Override
    @GetMapping("/{email}")
    public ResponseEntity<ResponseUsuarioDTO> buscarUsuario(@PathVariable String email){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.buscarUsuario(email);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    @PatchMapping("/{id}/nome")
    public ResponseEntity<ResponseUsuarioDTO> atualizarNomeUsuario(@PathVariable Integer id, @Valid @RequestBody NomeDTO nomeDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarNomeUsuario(id, nomeDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    @PatchMapping("/{id}/email")
    public ResponseEntity<ResponseUsuarioDTO> atualizarEmailUsuario(@PathVariable Integer id, @Valid @RequestBody EmailDTO emailDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarEmailUsuario(id, emailDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    @PatchMapping("/{id}/telefone")
    public ResponseEntity<ResponseUsuarioDTO> atualizarTelefoneUsuario(@PathVariable Integer id, @Valid @RequestBody TelefoneDTO telefoneDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarTelefoneUsuario(id, telefoneDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    @PatchMapping("/{id}/senha")
    public ResponseEntity<ResponseUsuarioDTO> atualizarSenhaUsuario(@PathVariable Integer id, @Valid @RequestBody SenhaDTO senhaDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarSenhaUsuario(id, senhaDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    @PatchMapping("/{id}/empresa")
    public ResponseEntity<ResponseUsuarioDTO> atualizarEmpresaUsuario(@PathVariable Integer id, @Valid @RequestBody EmpresaDTO empresaDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarEmpresaUsuario(id, empresaDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    @PatchMapping("/{id}/foto")
    public ResponseEntity<ResponseUsuarioDTO> atualizarFotoUsuario(@PathVariable Integer id, @Valid @RequestBody FotoDTO fotoDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarFotoUsuario(id, fotoDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
}
