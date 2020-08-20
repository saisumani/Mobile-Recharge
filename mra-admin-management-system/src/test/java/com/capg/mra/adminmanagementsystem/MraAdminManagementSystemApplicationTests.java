package com.capg.mra.adminmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.mra.adminmanagementsystem.dto.Admin;
import com.capg.mra.adminmanagementsystem.dto.Plans;
import com.capg.mra.adminmanagementsystem.repository.AdminRepo;
import com.capg.mra.adminmanagementsystem.repository.PlansRepo;
import com.capg.mra.adminmanagementsystem.service.IAdminService;
import com.capg.mra.adminmanagementsystem.service.IPlansService;


@SpringBootTest
class MraAdminManagementSystemApplicationTests {
	

	@Autowired
	 AdminRepo adminRepo;
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
    PlansRepo plansRepo;

	@Autowired
	IPlansService plansService;

	
	

	Admin admin1; 
	
	Plans plans1;
	
	@BeforeEach
	public void init()
	{
		admin1=new Admin((long)35,"12345","");
		plans1= new Plans( (long)48, "vishal plan", (long) 800, (long)78, "Idea", "Haryana");
		}
		

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
	



	
	
	
	
	
	

	@Test
	void contextLoads() {
	}

}
