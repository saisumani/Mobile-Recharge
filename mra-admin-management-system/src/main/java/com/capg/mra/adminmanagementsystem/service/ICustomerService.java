package com.capg.mra.adminmanagementsystem.service;

import java.util.List;

import com.capg.mra.adminmanagementsystem.dto.Customer;
import com.capg.mra.adminmanagementsystem.dto.Plans;
import com.capg.mra.adminmanagementsystem.dto.RechargeTransaction;
import com.capg.mra.adminmanagementsystem.dto.WalletHistory;
import com.capg.mra.adminmanagementsystem.exception.CustomerException;

public interface ICustomerService {

	public Customer registerCustomer(Customer customer);

	public Customer loginCustomer(String customerEmail, String customerPassword);

	public Customer rechargeWallet(Long CustomerId, Double amount);

	public Customer rechargeMobile(Long customerId, Plans plan, Long planPrice, String mobileNumber, String operator,
			String circle);

	public List<Plans> showPlans();

	public List<RechargeTransaction> showTransactionHistory(Long customerId);

	public List<WalletHistory> showWalletHistory(Long customerId);
	
	public Customer updateStatus(Long customerId);

	public Customer updateCustomerDetails(Customer customer);
}
