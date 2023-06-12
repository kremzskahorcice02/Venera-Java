package com.example.venera.repositories;

import com.example.venera.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    boolean findAdminByNameContainingAndAndPasswordContaining(String name, String password);

    Admin findAllByHashEquals(String hash);

    Admin findAllByNameContainingAndAndPasswordContaining(String name, String password);
}
