package com.capg.mra.adminmanagementsystem.service;

import java.util.List;

import com.capg.mra.adminmanagementsystem.dto.RechargeTransaction;

public interface IRechargeTransactionService {

	public RechargeTransaction addHistory(RechargeTransaction history);

	public List<RechargeTransaction> getRechargeHistory(Long customerId);

}
