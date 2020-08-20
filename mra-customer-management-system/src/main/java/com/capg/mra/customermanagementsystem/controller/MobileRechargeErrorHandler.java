package com.capg.mra.customermanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mra.customermanagementsystem.exception.AdminException;
import com.capg.mra.customermanagementsystem.exception.CustomerException;
import com.capg.mra.customermanagementsystem.exception.PlansException;
import com.capg.mra.customermanagementsystem.exception.RechargeTransactionException;
import com.capg.mra.customermanagementsystem.exception.WalletHistoryException;


/**
 * @author Boola Rohan
 * @author Sumani
 *
 */
/**
 * RestController annotation is used to create RESTful web services using Spring MVC. 
 * Spring RestController takes care of mapping request data to the defined request handler method.
 * inside package org.springframework.web.bind.annotation.RestController
 *
 */
@RestController
@ControllerAdvice
public class MobileRechargeErrorHandler {

		@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Admin Exception")
		@ExceptionHandler(AdminException.class)
		public void AdminException() {

		}

		@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Customer Exception")
		@ExceptionHandler(CustomerException.class)
		public void CustomerException() {

		}

		@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Plans Exception")
		@ExceptionHandler(PlansException.class)
		public void PlansException() {

		}

		@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Waller History Exception")
		@ExceptionHandler(WalletHistoryException.class)
		public void WalletHistoryException() {

		}

		@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Recharge Transaction Exception")
		@ExceptionHandler(RechargeTransactionException.class)
		public void RechargeTransactionException() {

		}
}

