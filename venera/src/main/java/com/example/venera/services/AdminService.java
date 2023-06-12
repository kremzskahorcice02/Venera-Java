package com.example.venera.services;

import com.example.venera.models.Admin;
import com.example.venera.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean validateAdmin(String name, String password) {
        return adminRepository.findAdminByNameContainingAndAndPasswordContaining(name, password);
    }

    public boolean validateAdminByHash(String hash) {
        if (adminRepository.findAllByHashEquals(hash) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Admin getAdmin(String name, String password) {
        return adminRepository.findAllByNameContainingAndAndPasswordContaining(name,password);
    }
}