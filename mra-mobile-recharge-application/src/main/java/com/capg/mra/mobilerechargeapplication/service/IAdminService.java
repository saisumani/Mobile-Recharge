package com.capg.mra.mobilerechargeapplication.service;

import java.util.List;

import com.capg.mra.mobilerechargeapplication.dto.Admin;
import com.capg.mra.mobilerechargeapplication.dto.Customer;
import com.capg.mra.mobilerechargeapplication.exception.AdminException;
/**
 * @author Sumani
 *
 */
public interface IAdminService {
	public Admin loginAdmin(Long adminId, String adminPassword) throws AdminException;

	public Admin addAdmin(Admin admin);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Long id);

}
