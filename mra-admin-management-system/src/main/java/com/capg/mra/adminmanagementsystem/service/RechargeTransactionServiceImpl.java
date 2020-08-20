package com.capg.mra.adminmanagementsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mra.adminmanagementsystem.dto.RechargeTransaction;
import com.capg.mra.adminmanagementsystem.exception.RechargeTransactionException;
import com.capg.mra.adminmanagementsystem.exception.WalletHistoryException;
import com.capg.mra.adminmanagementsystem.repository.RechargeTransactionRepo;

@Service
@Transactional
public class RechargeTransactionServiceImpl implements IRechargeTransactionService {
	
	@Autowired
	RechargeTransactionRepo rechargeTransactionRepo;

	@Override
	public RechargeTransaction addHistory(RechargeTransaction history) {
		return rechargeTransactionRepo.save(history);
	}

	@Override
	public List<RechargeTransaction> getRechargeHistory(Long customerId) {
		RechargeTransaction recharge = null;
		List<RechargeTransaction> list = new ArrayList<>();
		Iterable<RechargeTransaction> iterable = rechargeTransactionRepo.findByCustomerId(customerId);
		Iterator<RechargeTransaction> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			recharge = iterator.next();
			list.add(recharge);
		}
		if (list.isEmpty()) {

			throw new RechargeTransactionException("No Transactions Available");
		}
		return list;
	}

}
