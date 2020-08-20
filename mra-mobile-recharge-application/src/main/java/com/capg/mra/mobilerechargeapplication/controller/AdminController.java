package com.capg.mra.mobilerechargeapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mra.mobilerechargeapplication.dto.Admin;
import com.capg.mra.mobilerechargeapplication.dto.Customer;
import com.capg.mra.mobilerechargeapplication.dto.Plans;
import com.capg.mra.mobilerechargeapplication.service.IAdminService;
import com.capg.mra.mobilerechargeapplication.service.ICustomerService;
import com.capg.mra.mobilerechargeapplication.service.IPlansService;

/**
 * @author Sumani
 *
 */
/**
 * @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS).
 * This annotation is used at class level as well as method level in RESTful Web service controller. 
 * @CrossOrigin annotation is used at method level with @RequestMapping annotation.
 * inside package org.springframework.web.bind.annotation.CrossOrigin
 *
 */
@CrossOrigin(origins = {"http://localhost:4200"})
/**
 * RestController annotation is used to create RESTful web services using Spring MVC. 
 * Spring RestController takes care of mapping request data to the defined request handler method.
 * inside package org.springframework.web.bind.annotation.RestController
 *
 */
@RestController
/**
 * This annotation maps HTTP requests to handler methods of MVC and REST controllers
 * inside package org.springframework.web.bind.annotation.RequestMapping
 *
 */
@RequestMapping(value = "/admin")
public class AdminController {
	
	/*
	 * Autowired enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	 * inside package org.springframework.beans.factory.annotation.Autowired
	 */ 
		@Autowired
		IAdminService adminService;
		@Autowired
		ICustomerService customerService;
		@Autowired
		IPlansService plansService;
		
		/*
		 * Annotation for mapping HTTP GET requests onto specific handler methods.
		 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
		 * inside package org.springframework.web.bind.annotation.GetMapping
		 * http://localhost:9191/admin/adminLogin/adminId/adminPassword
		 * @param adminId
		 * @param adminPassword
		 * @response ResponseBean
		*/	
        @GetMapping(value = "/adminLogin/{adminId}/{adminPassword}")
		public Admin login(@PathVariable Long adminId, @PathVariable String adminPassword) {
			return adminService.loginAdmin(adminId, adminPassword);

		}

		
		/*
		 * Annotation for mapping HTTP POST requests onto specific handler methods. 
		 * Specifically, @PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST) .
		 * inside package org.springframework.web.bind.annotation.PostMapping
		 * http://localhost:9191/admin/addCustomerByAdmin
		 * @RequestBody customer data
		 * @return ResponseBean
		 * 
		*/
		@PostMapping("/addCustomerByAdmin")
		public Customer addCustomer(@RequestBody Customer customer) {
			customer.setAccountStatus("Pending");
			customer.setPlanDate("Inactive");
			customer.setCustomerWallet(0);
			customer.setCustomerPlan(0);
			customer.setPlanDate("Inactive");
			return customerService.registerCustomer(customer);

		}

		/*
		 * Annotation for mapping HTTP POST requests onto specific handler methods. 
		 * Specifically, @PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST) .
		 * inside package org.springframework.web.bind.annotation.PostMapping
		 * http://localhost:9191/admin/addAdminDetails
		 * 
		*/
		@PostMapping("/addAdminDetails")
		public Admin addAdminDetails(@RequestBody Admin admin) {

			return adminService.addAdmin(admin); 

		}

		/*
		 * Annotation for mapping HTTP POST requests onto specific handler methods. 
		 * Specifically, @PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST) .
		 * inside package org.springframework.web.bind.annotation.PostMapping
		 * http://localhost:9191/admin/addPlans
		 * 
		*/
		@PostMapping("/addPlans")
		public Plans addPlans(@RequestBody Plans plans) {
			return plansService.addPlans(plans); 
		}

		/*
		 * Annotation for mapping HTTP GET requests onto specific handler methods.
		 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
		 * inside package org.springframework.web.bind.annotation.GetMapping
		 * http://localhost:9191/admin/getAllPlans
		 * 
		*/
		@GetMapping("/getAllPlans")
		public List<Plans> getAllPlans() {
			return plansService.getAllPlans();
		}

		/*
		 * Annotation for mapping HTTP DELETE requests onto specific handler methods.
		 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE)
		 * inside package org.springframework.web.bind.annotation.DeleteMapping
		 * http://localhost:9191/admin/deletePlans/planId
		 * @param id
		*/
		@DeleteMapping("/deletePlans/{planId}")
		public boolean deletePlans(@PathVariable Long planId) {
			return plansService.removePlans(planId);

		}

		/*
		 * Annotation for mapping HTTP GET requests onto specific handler methods.
		 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
		 * inside package org.springframework.web.bind.annotation.GetMapping
		 * http://localhost:9191/admin/getCustomerById/customerid
		 * @param id
		*/
		@GetMapping("/getCustomerById/{customerId}")
		public Customer getCustomer(@PathVariable Long customerId) {
			return adminService.getCustomerById(customerId);
		}

		/*
		 * Annotation for mapping HTTP GET requests onto specific handler methods.
		 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
		 * inside package org.springframework.web.bind.annotation.GetMapping
		 * http://localhost:9191/admin/getAllCustomer
		 * @param id
		*/
		@GetMapping("/getAllCustomer")
		public List<Customer> getAllCustomers() {
			return adminService.getAllCustomers();
		}

		/*
		 * Annotation for mapping HTTP GET requests onto specific handler methods.
		 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
		 * inside package org.springframework.web.bind.annotation.GetMapping
		 * http://localhost:9191/admin/getPlans/planPrice
		 * @param value
		*/
		@GetMapping("/getPlans/{planPrice}")
		public List<Plans> getPlansByPlanPrice(@PathVariable Long planPrice) {
			return plansService.getPlansByPrize(planPrice);
		}


}
