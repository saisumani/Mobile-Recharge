package com.capg.mra.customermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mra.customermanagementsystem.dto.Admin;



/**
 * @author Sumani
 *
 */

public interface AdminRepo extends JpaRepository<Admin,Long>{

}