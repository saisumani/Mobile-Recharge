package com.capg.mra.customermanagementsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mra.customermanagementsystem.dto.WalletHistory;
import com.capg.mra.customermanagementsystem.exception.WalletHistoryException;
import com.capg.mra.customermanagementsystem.repository.WalletHistoryRepo;



/**
 * @author Boola Rohan
 *
 */
/**
 * @Service annotation is used in your service layer and annotates classes
 *  that perform service tasks, often you don't use it but in many case you use
 *  this annotation to represent a best practice.
 * this class handle all the cutomer services which implemented ICustomerService interface
 *
 */
@Service
/**
 * The transactional annotation itself defines the scope of a single database transaction. ... 
 * The persistence context is just a synchronizer object that tracks the state of a limited set of 
 * Java objects and makes sure that changes on those objects are eventually persisted back into the database.
 */
@Transactional
public class WalletHistoryServiceImpl implements IWalletHistoryService {
	/*
	 * Autowired enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	 * inside package org.springframework.beans.factory.annotation.Autowired
	 */
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

