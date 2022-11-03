package com.zorba.admin.service;

import com.zorba.admin.entity.Admin;
import com.zorba.admin.model.AdminModel;
import com.zorba.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public String saveAdminInfo(AdminModel adminModel) {
        Admin admin = new Admin();
        admin.setAdminName(adminModel.getAdminName());
        admin.setMobileNumber(adminModel.getMobileNumber());

        try {
            this.adminRepository.save(admin);
        } catch(Exception e) {
            return "fail";
        }
        return "success";
    }

    public AdminModel fetchAdminInfo(Long id) {
        AdminModel adminModel = new AdminModel();
        Optional<Admin> adminObj = this.adminRepository.findById(id);
        if (adminObj != null) {
            Admin admin = adminObj.get();
            adminModel.setMobileNumber(admin.getMobileNumber());
            adminModel.setAdminName(admin.getAdminName());
        }
        return adminModel;
    }
}
