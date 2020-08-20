package com.capg.mra.mobilerechargeapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mra.mobilerechargeapplication.dto.RechargeTransaction;

/**
 * @author Boola Rohan
 *
 */

public interface RechargeTransactionRepo extends JpaRepository<RechargeTransaction,Long >{

	public List<RechargeTransaction> findByCustomerId(Long customerId);
	 
	public boolean existsByMobileNumber(String mobileNumber);

}
