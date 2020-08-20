package com.capg.mra.mobilerechargeapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mra.mobilerechargeapplication.dto.WalletHistory;

/**
 * @author Boola Rohan
 *
 */

@Repository
public interface WalletHistoryRepo extends JpaRepository<WalletHistory,Long>{

	public List<WalletHistory> findByCustomerId(Long customerId);

}
