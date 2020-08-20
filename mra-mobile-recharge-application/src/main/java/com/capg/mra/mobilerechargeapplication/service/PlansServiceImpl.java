package com.capg.mra.mobilerechargeapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.mra.mobilerechargeapplication.dto.Plans;
import com.capg.mra.mobilerechargeapplication.exception.PlansException;
import com.capg.mra.mobilerechargeapplication.repository.PlansRepo;
/**
 * @author Boola Rohan
 * @author Sumani
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
public class PlansServiceImpl implements IPlansService{
	/*
	 * Autowired enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	 * inside package org.springframework.beans.factory.annotation.Autowired
	 */
	@Autowired
	PlansRepo plansRepo;

	@Override
	public Plans addPlans(Plans plans) {
		if(plansRepo.findByPlansName(plans.getPlansName())!=null)
		{
			throw new PlansException("Plan Name Already Exist ");
		}
		return plansRepo.save(plans);
	}

	@Override
	public boolean removePlans(Long planId) {
	    if(!plansRepo.existsById(planId))
	    {
	    	throw new PlansException("No PLan Available with given planId");
	    }
		plansRepo.deleteById(planId);
		return !plansRepo.existsById(planId);
	}

	@Override
	public List<Plans> getAllPlans(){
		
		List<Plans> plansList= plansRepo.findAll();
		if (plansList.isEmpty()) {
			throw new PlansException("No Plans Available");
			
		}
		return plansList;
		
	}

	@Override
	public List<Plans> getPlansByPrize(Long planPrize) {
		List<Plans> planList = plansRepo.findByPlansPrice(planPrize);
		if (planList.isEmpty()) {
			throw new PlansException("No Plans Available with the your mentioned details");	
		}
		return planList;

	}

	@Override
	public Plans findByPlansPriceAndOperatorAndCircle(Long price, String operator, String circle) {
		return plansRepo.findByPlansPriceAndOperatorAndCircle(price, operator, circle);
	}
	
	


}
