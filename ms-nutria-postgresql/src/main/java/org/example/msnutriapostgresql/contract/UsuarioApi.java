package org.example.msnutriapostgresql.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.msnutriapostgresql.dto.RequestUsuarioDTO;
import org.example.msnutriapostgresql.dto.ResponseUsuarioDTO;
import org.example.msnutriapostgresql.dto.updatedto.*;
import org.springframework.http.ResponseEntity;
@Tag(name = "Usuário", description = "Gestão do usuário")
public interface UsuarioApi {
    @Operation(summary = "Criar um novo usuário", description = "Recebe um dto com as informações do usuário e adiciona no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado no banco com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "400", description = "Os dados fornecidos são inválidos",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Bad Request",
                          "message": "O email informado é inválido"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> cadastrarUsuario(RequestUsuarioDTO requestUsuarioDTO);

    @Operation(summary = "Busca um usuário", description = "Recebe um email para buscar um usuário com base nele")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> buscarUsuario(String email);

    @Operation(summary = "Atualiza o nome do usuário", description = "Recebe um nome para atualizar o nome do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> atualizarNomeUsuario( Integer id, NomeDTO nomeDTO);

    @Operation(summary = "Atualiza o email do usuário", description = "Recebe um email para atualizar o email do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> atualizarEmailUsuario(Integer id, EmailDTO emailDTO);

    @Operation(summary = "Atualiza o telefone do usuário", description = "Recebe um telefone para atualizar o telefone do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> atualizarTelefoneUsuario(Integer id, TelefoneDTO telefoneDTO);

    @Operation(summary = "Atualiza a senha do usuário", description = "Recebe a senha antiga e a senha nova para atualizar a senha do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> atualizarSenhaUsuario(Integer id, SenhaDTO senhaDTO);
    @Operation(summary = "Atualiza a empresa do usuário", description = "Recebe o nome da empresa para atualizar o nome da empresa do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> atualizarEmpresaUsuario(Integer id, EmpresaDTO empresaDTO);

    @Operation(summary = "Atualiza a foto do usuário", description = "Recebe a url da foto para atualizar a foto do usuário no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "404", description = "Não foi possivel encontrar o usuário",
                    content = @Content(mediaType = "application/json",  examples = @ExampleObject(value = """
                        {
                          "status": 400,
                          "error": "Not Found",
                          "message": "Usuário não encontrado"
                        }
                    """)))
    })
    ResponseEntity<ResponseUsuarioDTO> atualizarFotoUsuario(Integer id, FotoDTO fotoDTO);
}
