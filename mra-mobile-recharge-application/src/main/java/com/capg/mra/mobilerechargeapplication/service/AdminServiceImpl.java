package com.capg.mra.mobilerechargeapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mra.mobilerechargeapplication.dto.Admin;
import com.capg.mra.mobilerechargeapplication.dto.Customer;
import com.capg.mra.mobilerechargeapplication.exception.AdminException;
import com.capg.mra.mobilerechargeapplication.exception.CustomerException;
import com.capg.mra.mobilerechargeapplication.repository.AdminRepo;
import com.capg.mra.mobilerechargeapplication.repository.CustomerRepo;
/**
 * @author Sumani
 *
 */
/**
 * @Service annotation is used in your service layer and annotates classes
 *  that perform service tasks, often you don't use it but in many case you use
 *  this annotation to represent a best practice.
 * 
 *
 */
@Service
public class AdminServiceImpl implements IAdminService {
	/*
	 * Autowired enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	 * inside package org.springframework.beans.factory.annotation.Autowired
	 */
	@Autowired
	AdminRepo adminRepo;

	@Autowired
	CustomerRepo customerRepo;
	
	/* method working as login for admin
	 * @param adminId,adminPassword
	 * @return admin type 
	 */
	@Override
	public Admin loginAdmin(Long adminId, String adminPassword)  {

		Admin admin = adminRepo.findById(adminId).get();
		if (!(admin.getAdminPassword().equals(adminPassword))) {
			throw new AdminException("Invalid Admin Credentials");
		} 
		return admin;

	}

	/*
	 * method user to register admin but whole system has only one admin
	 * @param Admin
	 * @return admin
	 * 
	 */
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	/*
	 * fetch All customers
	 * @return CustomerList 
	 */	
	@Override
	public List<Customer> getAllCustomers() {
		 List<Customer> customerList=customerRepo.findAll();
		if (customerList.isEmpty()) {
			throw new CustomerException("No Customers Available");
		}
	    return customerList;
	}

	/*
	 * fetch customer by customerId 
	 * @param customerId
	 * @return Customer 
	 */	
	@Override
	public Customer getCustomerById(Long customerId) {
		Customer customer = customerRepo.getOne(customerId);
	
		if (customer==null) {
			throw new CustomerException("Customer with ID "+ customerId +" is not available ");
		}
	
		return customer;
	}

}
