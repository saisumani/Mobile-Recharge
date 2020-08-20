package com.capg.mra.mobilerechargeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mra.mobilerechargeapplication.dto.Customer;
/**
 * @author Boola Rohan
 *
 */

public interface CustomerRepo extends JpaRepository<Customer, Long>{
	
public Customer findByCustomerEmail(String customerEmail);
	
	public Customer findByCustomerContact(String customerContact);
	
	public boolean existsByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
}
