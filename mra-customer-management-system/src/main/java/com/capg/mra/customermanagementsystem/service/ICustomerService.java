package com.capg.mra.customermanagementsystem.service;

import java.util.List;

import com.capg.mra.customermanagementsystem.dto.Customer;
import com.capg.mra.customermanagementsystem.dto.Plans;
import com.capg.mra.customermanagementsystem.dto.RechargeTransaction;
import com.capg.mra.customermanagementsystem.dto.WalletHistory;



/**
 * @author Boola Rohan
 *
 */
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

}

