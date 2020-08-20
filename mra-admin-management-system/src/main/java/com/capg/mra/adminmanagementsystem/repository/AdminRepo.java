package com.capg.mra.adminmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mra.adminmanagementsystem.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long>{

}
