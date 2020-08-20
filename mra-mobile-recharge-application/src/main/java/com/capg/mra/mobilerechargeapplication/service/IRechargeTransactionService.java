package com.capg.mra.mobilerechargeapplication.service;

import java.util.List;

import com.capg.mra.mobilerechargeapplication.dto.RechargeTransaction;
/**
 * @author Boola Rohan
 *
 */
public interface IRechargeTransactionService {
	
	public RechargeTransaction addHistory(RechargeTransaction history);

	public List<RechargeTransaction> getRechargeHistory(Long customerId);


}
