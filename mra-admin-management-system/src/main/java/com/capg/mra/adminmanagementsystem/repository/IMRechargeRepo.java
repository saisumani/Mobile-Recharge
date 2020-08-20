package com.capg.mra.adminmanagementsystem.repository;

import java.util.HashMap;

import com.capg.mra.adminmanagementsystem.dto.Customer;
import com.capg.mra.adminmanagementsystem.dto.Plans;

public interface IMRechargeRepo {

	public Long addCustomer(Customer customer);
	public boolean removeCustomer(Customer customer);
	public long addPlans(Plans plans);
	public void removePlans(Plans plans);
	public HashMap<Long, Customer> showCustomer();
	public HashMap<Long, Plans> showPlans();
	public Customer getCustomer(String cEmail,String cPwd);
	public Long showBalance(long customerId);
	public Long updateBalance(long customerId);
}
