package com.capg.mra.mobilerechargeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mra.mobilerechargeapplication.dto.Admin;
/**
 * @author Sumani
 *
 */

public interface AdminRepo extends JpaRepository<Admin,Long>{

}
