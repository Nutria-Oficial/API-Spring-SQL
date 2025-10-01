package org.example.msnutriapostgresql.controller;

import org.example.msnutriapostgresql.contract.UsuarioApi;
import org.example.msnutriapostgresql.dto.RequestUsuarioDTO;
import org.example.msnutriapostgresql.dto.ResponseUsuarioDTO;
import org.example.msnutriapostgresql.dto.updatedto.*;
import org.example.msnutriapostgresql.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController implements UsuarioApi {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public ResponseEntity<ResponseUsuarioDTO> cadastrarUsuario(RequestUsuarioDTO requestUsuarioDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.cadastrarUsuario(requestUsuarioDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> buscarUsuario(String email){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.buscarUsuario(email);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> atualizarNomeUsuario(Integer id, NomeDTO nomeDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarNomeUsuario(id, nomeDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> atualizarEmailUsuario(Integer id, EmailDTO emailDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarEmailUsuario(id, emailDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> atualizarTelefoneUsuario(Integer id, TelefoneDTO telefoneDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarTelefoneUsuario(id, telefoneDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> atualizarSenhaUsuario(Integer id, SenhaDTO senhaDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarSenhaUsuario(id, senhaDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> atualizarEmpresaUsuario(Integer id, EmpresaDTO empresaDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarEmpresaUsuario(id, empresaDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ResponseUsuarioDTO> atualizarFotoUsuario(Integer id, FotoDTO fotoDTO){
        ResponseUsuarioDTO responseUsuarioDTO = usuarioService.atualizarFotoUsuario(id, fotoDTO);
        return new ResponseEntity<>(responseUsuarioDTO, HttpStatus.OK);
    }
}
