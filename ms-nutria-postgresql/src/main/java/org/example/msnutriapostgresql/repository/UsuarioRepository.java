package org.example.msnutriapostgresql.repository;

import org.example.msnutriapostgresql.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Procedure(procedureName = "proc_adicionar_usuario")
    void adicionarUsuario(@Param("usuario") String nome, @Param("email") String email, @Param("senha") String senha, @Param("telefone") String telefone, @Param("empresa") String empresa, @Param("foto") String foto);
    Usuario findTopByOrderByIdDesc();
    Optional<Usuario> findByEmail(String email);

}
