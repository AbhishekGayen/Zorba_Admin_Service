package com.zorba.admin.repository;

import com.zorba.admin.entity.Admin;
import com.zorba.admin.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
