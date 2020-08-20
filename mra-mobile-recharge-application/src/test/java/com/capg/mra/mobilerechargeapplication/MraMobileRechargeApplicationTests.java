package com.capg.mra.mobilerechargeapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.Column;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.mra.mobilerechargeapplication.dto.Admin;
import com.capg.mra.mobilerechargeapplication.dto.Customer;
import com.capg.mra.mobilerechargeapplication.dto.Plans;
import com.capg.mra.mobilerechargeapplication.repository.AdminRepo;
import com.capg.mra.mobilerechargeapplication.repository.CustomerRepo;
import com.capg.mra.mobilerechargeapplication.repository.PlansRepo;
import com.capg.mra.mobilerechargeapplication.service.IAdminService;
import com.capg.mra.mobilerechargeapplication.service.ICustomerService;
import com.capg.mra.mobilerechargeapplication.service.IPlansService;

@SpringBootTest
class MraMobileRechargeApplicationTests {
	
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	 AdminRepo adminRepo;
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	PlansRepo plansRepo;
	
	@Autowired
	IPlansService plansService;
	
	Customer customer1;
	Customer customer2;
	Customer customer3;
	
	Admin admin1; 
	
	Plans plans1;
	
	@BeforeEach
	public void init()
	{
		customer1=new Customer((long) 2,"Rohan","7893732190","rohanrocks14m@gmail.com",499,"2020/11/08",403.0,"123Roh123","Verified");
		customer2=new Customer((long) 20,"Ravi","7893732191","boolarohan14m@gmail.com",449,"2020/11/08",452.0,"123Rav123","Verified");
		customer3=new Customer((long) 25,"Kumar","7893732192","boolarohan14m@hotmail.com",149,"2020/11/08",452.0,"123Kum123","Verified");
		admin1= new Admin((long)19,"12345","");
		plans1= new Plans( (long)35, "vidhya plan", (long) 509, (long)86 , "Airtel", "Assam");
	}
	
	
	@Test
	void testLoginCustomer() {
		
	Customer customer=  customerService.loginCustomer("rohanrocks14m@gmail.com","123Roh123");
            assertEquals(true,customer!=null );
	
	}
	
//	@Test
//	void testRegisterCustomer() {
//		Customer customer= customerService.registerCustomer(customer3);
//		assertEquals(true,customer!=null);
	
//	}
	
	
	 @Test void testAddPlans() { Plans plans = plansService.addPlans(plans1);
	 assertEquals(true, plans!=null); }
	 
	
	
	
	/*
	 * @Test void testRemovePlans() { boolean plans =
	 * plansService.removePlans((long)21); assertEquals(false, plans=(Boolean)true);
	 * }
	 */
	 
	 
	
	@Test
	void testLoginAdmin() {
		Admin admin = adminService.addAdmin(admin1);
		assertEquals(true,admin!=null);
	}
	

}
