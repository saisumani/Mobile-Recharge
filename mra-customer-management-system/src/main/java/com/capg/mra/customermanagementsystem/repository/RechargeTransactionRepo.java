package com.capg.mra.customermanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mra.customermanagementsystem.dto.RechargeTransaction;



/**
 * @author Boola Rohan
 *
 */

public interface RechargeTransactionRepo extends JpaRepository<RechargeTransaction,Long >{

	public List<RechargeTransaction> findByCustomerId(Long customerId);
	 
	public boolean existsByMobileNumber(String mobileNumber);

}
