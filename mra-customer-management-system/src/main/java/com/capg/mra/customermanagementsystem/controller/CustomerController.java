package com.capg.mra.customermanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mra.customermanagementsystem.dto.Customer;
import com.capg.mra.customermanagementsystem.dto.Plans;
import com.capg.mra.customermanagementsystem.dto.RechargeTransaction;
import com.capg.mra.customermanagementsystem.dto.WalletHistory;
import com.capg.mra.customermanagementsystem.service.ICustomerService;
import com.capg.mra.customermanagementsystem.service.IPlansService;
import com.capg.mra.customermanagementsystem.service.IRechargeTransactionService;
import com.capg.mra.customermanagementsystem.service.IWalletHistoryService;


/**
 * @author Boola Rohan
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
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 * Autowired enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
	 * inside package org.springframework.beans.factory.annotation.Autowired
	 */
			@Autowired
			ICustomerService customerService;

			@Autowired
			IPlansService plansService;

			@Autowired
			IWalletHistoryService walletService;

			@Autowired
			IRechargeTransactionService rechargeTransactionService;

			/**
			 * Annotation for mapping HTTP POST requests onto specific handler methods. 
			 * Specifically, @PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST) .
			 * inside package org.springframework.web.bind.annotation.PostMapping
			 * http://localhost:9191/customer/register
			 * is this context customer will be registered and wants user json data to be persist
			 * @param customer
			 * @return customer response bean
			 */
			@PostMapping("/register")
			public Customer regsiterCustomer(@RequestBody Customer customer) {
				customer.setAccountStatus("Pending");
				customer.setPlanDate("Inactive");
				customer.setCustomerWallet(0);
				customer.setCustomerPlan(0);
				customer.setPlanDate("Inactive");
				Customer customer1 = customerService.registerCustomer(customer);
				return customer1;
			}

			/**
			 * Annotation for mapping HTTP GET requests onto specific handler methods.
			 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
			 * inside package org.springframework.web.bind.annotation.GetMapping
			 * @param customerEmail
			 * @param customerPassword
			 * @return response customer type
			 */
			@GetMapping("/login/{customerEmail}/{customerPassword}")
			public Customer login(@PathVariable String customerEmail, @PathVariable String customerPassword) {
				return customerService.loginCustomer(customerEmail, customerPassword);

			}

			/**
			 * Annotation for mapping HTTP PUT requests onto specific handler methods.
			 * Specifically, @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT)
			 * inside package org.springframework.web.bind.annotation.PutMapping
			 * http://localhost:9191/customer/rechargeWallet
			 * Customer recharge its phone updated data will persisted.
			 * @param customerId
			 * @param amount
			 * @return ResponseEntity customer type
			 */
			@PutMapping("/rechargeWallet/{customerId}/{amount}")
			public Customer rechargeWallet(@PathVariable Long customerId, @PathVariable Double amount) {
				return customerService.rechargeWallet(customerId, amount);

			}

			/**
			 * Annotation for mapping HTTP PUT requests onto specific handler methods.
			 * Specifically, @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT)
			 * inside package org.springframework.web.bind.annotation.PutMapping
			 * @param customerId
			 * @param price
			 * @param mobileNumber
			 * @param operator
			 * @param circle
			 * @return RESPONSE ENTITY OF CUSTOMER
			 */
			@PutMapping("/rechargeMobile/{customerId}/{price}/{mobileNumber}/{operator}/{circle}")
			public Customer rechargeMobile(@PathVariable Long customerId,@PathVariable Long price,@PathVariable String mobileNumber,@PathVariable String operator,@PathVariable String circle) {
				Plans plan=plansService.findByPlansPriceAndOperatorAndCircle(price, operator, circle);
				System.out.println(plan);
				return customerService.rechargeMobile(customerId, plan, plan.getPlansPrice(), mobileNumber, plan.getOperator(), plan.getCircle());

			}

			/**
			 * Annotation for mapping HTTP GET requests onto specific handler methods.
			 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
			 * inside package org.springframework.web.bind.annotation.GetMapping
			 * http://localhost:9191/customer/viewPlans
			 * @return plans List
			 */
			@GetMapping("/viewPlans")
			public List<Plans> viewPlans() {

				return plansService.getAllPlans();
			}

			/**
			 * Annotation for mapping HTTP GET requests onto specific handler methods.
			 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
			 * inside package org.springframework.web.bind.annotation.GetMapping
			 * @param customerId
			 * @return Get plans by planPrice
			 */
			@GetMapping("/getPlans/{planPrice}")
			public List<Plans> getPlansByPlanPrice(@PathVariable Long planPrice) {
				return plansService.getPlansByPrize(planPrice);
			}

			/**
			 * Annotation for mapping HTTP GET requests onto specific handler methods.
			 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
			 * inside package org.springframework.web.bind.annotation.GetMapping
			 * @param customerId
			 * @return list of wallet history
			 */
			@GetMapping("/getWalletHistory/{customerId}")
			public List<WalletHistory> getWalletHistory(@PathVariable Long customerId) {
				return walletService.getWalletHistory(customerId);
			}

			/**
			 * Annotation for mapping HTTP GET requests onto specific handler methods.
			 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
			 * inside package org.springframework.web.bind.annotation.GetMapping
			 * @param customerId
			 * @return list of Recharge history
			 */
			@GetMapping("/getRechargeHistory/{customerId}")
			public List<RechargeTransaction> getRechargeHistory(@PathVariable Long customerId) {
				return rechargeTransactionService.getRechargeHistory(customerId);
			}

			/**
			 * 
			 * @param id
			 * @return string
			 */
			@RequestMapping("/verifyAccount/{customerId}")
			public String updateStatus(@PathVariable Long customerId) {
				String msg = "";
				try {
					if (customerService.updateStatus(customerId) != null) {
						msg = "Account Verified You May Close The Window";
					}
				} catch (Exception e) {
					msg = "Something Went Wrong Try Again";
				}
				return msg;
			}
			
			/**
			 * Annotation for mapping HTTP GET requests onto specific handler methods.
			 * Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
			 * inside package org.springframework.web.bind.annotation.GetMapping
			 * @param price
			 * @param operator
			 * @param circle
			 * @return list of plan details
			 */
			@GetMapping("/plan/{price}/{operator}/{circle}")
			public Plans getPlan(@PathVariable Long price, @PathVariable String operator, @PathVariable String circle )
			{
				return plansService.findByPlansPriceAndOperatorAndCircle(price, operator, circle);
			}


	
}
