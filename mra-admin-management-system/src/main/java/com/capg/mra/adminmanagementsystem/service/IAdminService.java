package com.capg.mra.adminmanagementsystem.service;

import java.util.List;

import com.capg.mra.adminmanagementsystem.dto.Admin;
import com.capg.mra.adminmanagementsystem.dto.Customer;
import com.capg.mra.adminmanagementsystem.dto.Plans;
import com.capg.mra.adminmanagementsystem.exception.AdminException;

public interface IAdminService {
	
	public Admin loginAdmin(Long adminId, String adminPassword) throws AdminException;

	public Admin addAdmin(Admin admin);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Long id);
	
}
