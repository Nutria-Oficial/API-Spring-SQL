package org.example.msnutriapostgresql.controller;

import org.example.msnutriapostgresql.contract.AdminApi;
import org.example.msnutriapostgresql.dto.RequestAdminDTO;
import org.example.msnutriapostgresql.dto.ResponseAdminDTO;
import org.example.msnutriapostgresql.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController implements AdminApi {
  private final AdminService adminService;

  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @Override
  @GetMapping("/login")
  public ResponseEntity<ResponseAdminDTO> loginAdmin(@PathVariable RequestAdminDTO requestAdminDTO) {
    ResponseAdminDTO responseAdminDTO = adminService.loginAdmin(requestAdminDTO);
    return new ResponseEntity<>(responseAdminDTO, HttpStatus.OK);
  }
}
