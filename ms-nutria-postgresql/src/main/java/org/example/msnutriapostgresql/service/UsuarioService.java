package org.example.msnutriapostgresql.service;

import org.example.msnutriapostgresql.dto.RequestUsuarioDTO;
import org.example.msnutriapostgresql.dto.ResponseUsuarioDTO;
import org.example.msnutriapostgresql.dto.updatedto.*;
import org.example.msnutriapostgresql.exception.DuplicateException;
import org.example.msnutriapostgresql.exception.NotFoundException;
import org.example.msnutriapostgresql.model.Usuario;
import org.example.msnutriapostgresql.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public ResponseUsuarioDTO cadastrarUsuario(RequestUsuarioDTO requestUsuarioDTO){
        usuarioRepository.adicionarUsuario(requestUsuarioDTO.nome(), requestUsuarioDTO.email(), requestUsuarioDTO.senha(), requestUsuarioDTO.telefone(), requestUsuarioDTO.empresa(), requestUsuarioDTO.foto());
        Usuario usuarioCadastrado = usuarioRepository.findTopByOrderByIdDesc();
        return new ResponseUsuarioDTO(usuarioCadastrado.getNome(), usuarioCadastrado.getEmail(), usuarioCadastrado.getSenha(), usuarioCadastrado.getTelefone(), usuarioCadastrado.getEmpresa(), usuarioCadastrado.getFoto());
    }
    public ResponseUsuarioDTO buscarUsuario(String email){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(email);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioEncontrado.get();
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());
    }
    public ResponseUsuarioDTO atualizarNomeUsuario(Integer id, NomeDTO nomeDTO) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioEncontrado.get();
        usuario.setNome(nomeDTO.nome());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());

    }
    public ResponseUsuarioDTO atualizarEmailUsuario(Integer id, EmailDTO emailDTO){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioEncontrado.get();
        usuario.setEmail(emailDTO.email());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());
    }
    public ResponseUsuarioDTO atualizarTelefoneUsuario(Integer id, TelefoneDTO telefoneDTO){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioEncontrado.get();
        usuario.setTelefone(telefoneDTO.telefone());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());
    }
    public ResponseUsuarioDTO atualizarSenhaUsuario(Integer id, SenhaDTO senhaDTO){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        if (Objects.equals(senhaDTO.senhaAntiga(), senhaDTO.senhaNova())){
            throw new DuplicateException("A nova senha deve ser diferente da antiga");
        }
        Usuario usuario = usuarioEncontrado.get();
        usuario.setSenha(senhaDTO.senhaNova());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());
    }
    public ResponseUsuarioDTO atualizarEmpresaUsuario(Integer id, EmpresaDTO empresaDTO){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioEncontrado.get();
        usuario.setEmpresa(empresaDTO.empresa());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());
    }
    public ResponseUsuarioDTO atualizarFotoUsuario(Integer id, FotoDTO fotoDTO){
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        Usuario usuario = usuarioEncontrado.get();
        usuario.setFoto(fotoDTO.foto());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEmpresa(), usuario.getFoto());
    }

}
