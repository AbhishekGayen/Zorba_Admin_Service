package com.zorba.admin.controller;

import com.zorba.admin.model.AdminModel;
import com.zorba.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/fetchAdminInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminModel fetchStudentInfo(@RequestParam(name="admin_Id") Long stuId) {
        AdminModel adminModel = this.adminService.fetchAdminInfo(stuId);
        return adminModel;
    }

    @PostMapping(value = "/saveAdminInfo")
    public String saveStudentInfo(@RequestBody AdminModel adminModel) {
        String response = this.adminService.saveAdminInfo(adminModel);
        return response;
    }
}
