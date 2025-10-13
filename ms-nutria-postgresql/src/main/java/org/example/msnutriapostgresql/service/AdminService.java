package org.example.msnutriapostgresql.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import org.example.msnutriapostgresql.dto.RequestAdminDTO;
import org.example.msnutriapostgresql.dto.ResponseAdminDTO;
import org.example.msnutriapostgresql.exception.NotFoundException;
import org.example.msnutriapostgresql.model.Admin;
import org.example.msnutriapostgresql.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  private final AdminRepository adminRepository;

  public AdminService(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  public ResponseAdminDTO loginAdmin(RequestAdminDTO requestAdminDTO) {
    Optional<Admin> adminEncontrado = adminRepository.findByEmail(requestAdminDTO.email());
    if (adminEncontrado.isEmpty()
        || !adminEncontrado.get().getSenha().equals(requestAdminDTO.senha())) {
      throw new NotFoundException("Usuário ou senha incorretos");
    }

    // Calculando a idade do admin
    LocalDate dataNascimento = adminEncontrado.get().getDataNascimento();
    LocalDate dataAtual = LocalDate.now();

    Integer idade = Period.between(dataNascimento, dataAtual).getYears();

    Admin admin = adminEncontrado.get();
    return new ResponseAdminDTO(
        admin.getNome(),
        admin.getEmail(),
        admin.getTelefone(),
        admin.getCargo(),
        admin.getFoto(),
        idade);
  }
}
