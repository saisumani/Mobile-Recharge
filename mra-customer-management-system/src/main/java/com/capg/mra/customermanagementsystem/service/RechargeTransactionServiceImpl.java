package com.capg.mra.customermanagementsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mra.customermanagementsystem.dto.RechargeTransaction;
import com.capg.mra.customermanagementsystem.exception.RechargeTransactionException;
import com.capg.mra.customermanagementsystem.repository.RechargeTransactionRepo;



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
 * 
 *
 */
@Transactional
public class RechargeTransactionServiceImpl implements IRechargeTransactionService{

	/*
	 * Autowired enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	 * inside package org.springframework.beans.factory.annotation.Autowired
	 */
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

