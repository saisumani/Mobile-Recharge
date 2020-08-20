package com.capg.mra.adminmanagementsystem.service;

import java.util.List;

import com.capg.mra.adminmanagementsystem.dto.Plans;
import com.capg.mra.adminmanagementsystem.exception.PlansException;

public interface IPlansService {

	public Plans addPlans(Plans plan);

	public boolean removePlans(Long planId);
	
	public Plans findByPlansPriceAndOperatorAndCircle(Long price, String operator,String circle);

	public List<Plans> getAllPlans();

	public List<Plans> getPlansByPrize(Long planPrize);
}
