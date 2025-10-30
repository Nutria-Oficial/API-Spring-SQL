package org.example.msnutriapostgresql.dto.updatedto;

import jakarta.validation.constraints.NotBlank;

public class EmpresaDTO{
    @NotBlank(message = "O nome da foto deve ser informada") String empresa;

    public EmpresaDTO() {
    }

    public EmpresaDTO(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
