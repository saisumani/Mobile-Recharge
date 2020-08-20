package com.capg.mra.customermanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mra.customermanagementsystem.dto.WalletHistory;



/**
 * @author Boola Rohan
 *
 */

@Repository
public interface WalletHistoryRepo extends JpaRepository<WalletHistory,Long>{

	public List<WalletHistory> findByCustomerId(Long customerId);

}
