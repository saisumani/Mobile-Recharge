package com.capg.mra.adminmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mra.adminmanagementsystem.dto.WalletHistory;

public interface WalletHistoryRepo extends JpaRepository<WalletHistory,Long>{

	public List<WalletHistory> findByCustomerId(Long customerId);
}
