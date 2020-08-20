package com.capg.mra.mobilerechargeapplication.service;

import java.util.List;

import com.capg.mra.mobilerechargeapplication.dto.Customer;
import com.capg.mra.mobilerechargeapplication.dto.Plans;
import com.capg.mra.mobilerechargeapplication.dto.RechargeTransaction;
import com.capg.mra.mobilerechargeapplication.dto.WalletHistory;

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
