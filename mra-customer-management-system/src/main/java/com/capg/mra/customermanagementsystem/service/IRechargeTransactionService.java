package com.capg.mra.customermanagementsystem.service;

import java.util.List;

import com.capg.mra.customermanagementsystem.dto.RechargeTransaction;



/**
 * @author Boola Rohan
 *
 */
public interface IRechargeTransactionService {
	
	public RechargeTransaction addHistory(RechargeTransaction history);

	public List<RechargeTransaction> getRechargeHistory(Long customerId);


}
