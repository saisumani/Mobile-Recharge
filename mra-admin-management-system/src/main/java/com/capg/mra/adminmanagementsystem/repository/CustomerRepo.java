package com.capg.mra.adminmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mra.adminmanagementsystem.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	public Customer findByCustomerEmail(String customerEmail);
	
	public Customer findByCustomerContact(String customerContact);
	
	public boolean existsByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
}
