package org.example.msnutriapostgresql.repository;

import java.util.Optional;
import org.example.msnutriapostgresql.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
  Optional<Admin> findByEmail(String email);
}
