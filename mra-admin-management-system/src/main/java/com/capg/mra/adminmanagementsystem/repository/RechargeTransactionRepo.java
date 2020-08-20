package com.capg.mra.adminmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mra.adminmanagementsystem.dto.RechargeTransaction;

public interface RechargeTransactionRepo extends JpaRepository<RechargeTransaction,Long >{

	public List<RechargeTransaction> findByCustomerId(Long customerId);
}
