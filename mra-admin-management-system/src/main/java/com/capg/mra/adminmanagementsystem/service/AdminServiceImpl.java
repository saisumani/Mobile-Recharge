package com.capg.mra.adminmanagementsystem.service;

import java.util.List;

import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.mra.adminmanagementsystem.dto.Admin;
import com.capg.mra.adminmanagementsystem.dto.Customer;
import com.capg.mra.adminmanagementsystem.exception.AdminException;
import com.capg.mra.adminmanagementsystem.exception.CustomerException;
import com.capg.mra.adminmanagementsystem.repository.AdminRepo;
import com.capg.mra.adminmanagementsystem.repository.CustomerRepo;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public Admin loginAdmin(Long adminId, String adminPassword)  {

		Admin admin = adminRepo.findById(adminId).get();
		if (!(admin.getAdminPassword().equals(adminPassword))) {
			throw new AdminException("Invalid Admin Credentials");
		} 
		return admin;

	}

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public List<Customer> getAllCustomers() {
		 List<Customer> customerList=customerRepo.findAll();
		if (customerList.isEmpty()) {
			throw new CustomerException("No Customers Available");
		}
	    return customerList;
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		Customer customer = customerRepo.getOne(customerId);
	
		if (customer==null) {
			throw new CustomerException("Customer with ID "+ customerId +" is not available ");
		}
	
		return customer;
	}

}
