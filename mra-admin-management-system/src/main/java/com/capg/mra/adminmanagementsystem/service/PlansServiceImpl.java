package com.capg.mra.adminmanagementsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.mra.adminmanagementsystem.dto.Plans;
import com.capg.mra.adminmanagementsystem.exception.PlansException;
import com.capg.mra.adminmanagementsystem.repository.PlansRepo;

@Service
@Transactional
public class PlansServiceImpl implements IPlansService {

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
