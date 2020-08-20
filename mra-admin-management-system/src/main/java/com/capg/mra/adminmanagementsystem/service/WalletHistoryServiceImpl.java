package com.capg.mra.adminmanagementsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mra.adminmanagementsystem.dto.WalletHistory;
import com.capg.mra.adminmanagementsystem.exception.WalletHistoryException;
import com.capg.mra.adminmanagementsystem.repository.WalletHistoryRepo;

@Service
@Transactional
public class WalletHistoryServiceImpl implements IWalletHistoryService {

	@Autowired
	WalletHistoryRepo walletHistoryRepo;
	
	@Override
	public WalletHistory addHistory(WalletHistory walletHistory) {
		return walletHistoryRepo.save(walletHistory);
	}

	@Override
	public List<WalletHistory> getWalletHistory(Long id) {
		WalletHistory history = null;
		List<WalletHistory> list = new ArrayList<>();
		Iterable<WalletHistory> iterable = walletHistoryRepo.findByCustomerId(id);
		Iterator<WalletHistory> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			history = iterator.next();
			list.add(history);
			
		}
		if (list.isEmpty()) {

			throw new WalletHistoryException("No Transactions Available");
		}
		return list;
	}

}
