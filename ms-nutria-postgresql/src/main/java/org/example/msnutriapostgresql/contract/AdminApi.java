package org.example.msnutriapostgresql.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.msnutriapostgresql.dto.RequestAdminDTO;
import org.example.msnutriapostgresql.dto.ResponseAdminDTO;
import org.example.msnutriapostgresql.dto.exceptiondto.ErrorDTO;
import org.springframework.http.ResponseEntity;

@Tag(name = "Admin", description = "Gestão do admin")
public interface AdminApi {
    @Operation(
            summary = "Busca um admin",
            description = "Recebe um email e uma senha para buscar um admin com essas informações")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Admin encontrado com sucesso",
                    content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseAdminDTO.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Não foi possivel encontrar o admin",
                    content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class)))
    })
    ResponseEntity<ResponseAdminDTO> loginAdmin(RequestAdminDTO requestAdminDTO);
}
