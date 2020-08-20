package com.capg.mra.adminmanagementsystem.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.mra.adminmanagementsystem.dto.Customer;
import com.capg.mra.adminmanagementsystem.dto.Plans;
import com.capg.mra.adminmanagementsystem.dto.RechargeTransaction;
import com.capg.mra.adminmanagementsystem.dto.WalletHistory;
import com.capg.mra.adminmanagementsystem.exception.CustomerException;
import com.capg.mra.adminmanagementsystem.exception.PlansException;
import com.capg.mra.adminmanagementsystem.exception.RechargeTransactionException;
import com.capg.mra.adminmanagementsystem.exception.WalletHistoryException;
import com.capg.mra.adminmanagementsystem.repository.CustomerRepo;
import com.capg.mra.adminmanagementsystem.repository.PlansRepo;
import com.capg.mra.adminmanagementsystem.repository.RechargeTransactionRepo;
import com.capg.mra.adminmanagementsystem.repository.WalletHistoryRepo;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	MailService mailService;

	@Autowired
	PlansRepo plansRepo;

	@Autowired
	RechargeTransactionRepo rechargeTransactionRepo;

	@Autowired
	WalletHistoryRepo walletHistoryRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		if (customerRepo.findByCustomerContact(customer.getCustomerContact()) != null) {
			throw new CustomerException("Contact Already Exists");

		}
		if (customerRepo.findByCustomerEmail(customer.getCustomerEmail()) != null) {
			throw new CustomerException("Email Already Exists");
		}
		customerRepo.save(customer);
		String link = "http://localhost:9191/customer/verifyAccount/" + customer.getCustomerId();
		String toEmail = customer.getCustomerEmail();
		String subject = "Verify your Account";
		String message = "<h3> Dear Customer, </h3> <br>  Click on the Below link to Verify your Account<br> <a href='"
				+ link + "'>click here to verify</a>";

		try {
			mailService.sendMail(toEmail, subject, message);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

		return customer;

	}

	@Override
	public Customer loginCustomer(String email, String password) {

		Customer customer = customerRepo.findByCustomerEmail(email);
		if (!customerRepo.existsByCustomerEmailAndCustomerPassword(email, password)) {

			throw new CustomerException("Invalid Credentials");
		}
		return customer;
	}

	@Override
	public List<RechargeTransaction> showTransactionHistory(Long customerId) {

		List<RechargeTransaction> rechargeTransactionList = rechargeTransactionRepo.findByCustomerId(customerId);
		if (rechargeTransactionList.isEmpty()) {

			throw new RechargeTransactionException("No Transactions Found");

		}
		return rechargeTransactionList;
	}

	@Override
	public Customer rechargeWallet(Long customerId, Double amount) {

		Customer customer = customerRepo.getOne(customerId);
		if (customer.getAccountStatus().equals("Pending")) {

			throw new CustomerException("Please verify your Account");

		} else {

			customer.setCustomerWallet(customer.getCustomerWallet() + amount);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			WalletHistory walletHistory = new WalletHistory();
			walletHistory.setCustomerId(customerId);
			walletHistory.setAmount(amount);
			walletHistory.setDateTime(dtf.format(now));
			walletHistory.setType("Credit");
			walletHistoryRepo.save(walletHistory);
			customerRepo.save(customer);

			String toEmail = customer.getCustomerEmail();
			String subject = "Added money to Wallet Account";
			String message = "<h3> Dear Customer, <br><br> &nbsp;&nbsp; Amount of INR " + amount
					+ " has been Credited to your Wallet on" + dtf.format(now)
					+ " Available balance is INR <label color='yellow'>" + customer.getCustomerWallet()
					+ "</label><br><br><br> Warm Regards, <br> Mobile Recharge. </h3>";
			try {
				mailService.sendMail(toEmail, subject, message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		return customer;
	}

	@Override
	public Customer rechargeMobile(Long customerId, Plans plan, Long planPrice, String mobileNumber, String operator,
			String circle) {
		Customer customer = customerRepo.findById(customerId).get();
		String toEmail, subject, message, link;
		if (customer.getAccountStatus().equals("Pending")) {

			link = "http://localhost:9191/customer/verifyAccount/" + customer.getCustomerId();
			toEmail = customer.getCustomerEmail();
			subject = "Verify your Account";
			message = "<h3> Dear </h3>" + customer.getCustomerName()
					+ ",<br>  Click on the Below link to Verify your Account<br> <a href='" + link
					+ "'>click here to verify</a>";
			throw new CustomerException("Please verify your Account");

		} else if (customer.getCustomerWallet() < planPrice) {
			toEmail = customer.getCustomerEmail();
			subject = "Insufficient Balance";
			message = "You dont sufficient Ballance in your Wallet Recharge your Wallet";
			throw new CustomerException("Insufficient Wallet Balance");
		} else if (customer.getCustomerContact().equals(mobileNumber) && !customer.getPlanDate().equals("Inactive")) {
			toEmail = customer.getCustomerEmail();
			subject = "Your Plan is Active";
			message = "Your Plan is Active";
			throw new CustomerException("Plan Active");
		} else if (plan == null) {
			toEmail = customer.getCustomerEmail();
			subject = "Invalid Plan";
			message = "Selected Plans is not in the Plans List Please Select Right Plan";
			throw new CustomerException("Invalid Plan");
		} else {
			Long val = plan.getValidity();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, val.intValue());
			String newDate = sdf.format(cal.getTime());

			if (mobileNumber.equals(customer.getCustomerContact())) {
				customer.setPlanDate(newDate);
			} else {
				customer.setPlanDate("Inactive");
			}

			Double updateWalletBallance = customer.getCustomerWallet() - planPrice;
			customer.setCustomerPlan(planPrice.intValue());
			customer.setCustomerWallet(updateWalletBallance);

			// Adding the transaction history-------------------------------------------
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			RechargeTransaction rechargeT = new RechargeTransaction();
			rechargeT.setCustomerId(customerId);
			rechargeT.setMobileNumber(mobileNumber);
			rechargeT.setRechargeName(plan.getPlansName());
			rechargeT.setRechargePrice(plan.getPlansPrice());
			rechargeT.setRechargeValidity(plan.getValidity().intValue());
			rechargeT.setTransactionDateTime(dtf.format(now));
			rechargeT.setOperator(operator);
			rechargeT.setCircle(circle);

			// Adding Wallet Transaction History
			WalletHistory walletHistory = new WalletHistory();
			walletHistory.setCustomerId(customerId);
			walletHistory.setDateTime(dtf.format(now));
			walletHistory.setAmount(planPrice.doubleValue());
			walletHistory.setType("Debit");
			walletHistoryRepo.save(walletHistory);

			toEmail = customer.getCustomerEmail();
			subject = "Mobile Recharge Wallet Account Update";
			message = "<h3> Dear Customer, <br><br> &nbsp;&nbsp; Amount of INR " + planPrice
					+ " has been Debited to your Wallet at Mumbai on " + dtf.format(now)
					+ " Available balance is INR <label color='yellow'>" + customer.getCustomerWallet()
					+ "</label><br><br><br> Warm Regards, <br> Mobile Recharge. </h3>";

			rechargeTransactionRepo.save(rechargeT);
//			------------------------------------------------------------------------------
			// Mailing Rechage update

			String toEmail1 = customer.getCustomerEmail();
			String subject1 = "Your Mobile Recharge for Rs." + planPrice + " is Successful.";
			String message1 = "<h3> Dear Customer, <br><br> your Mobile Recharge for " + customer.getCustomerContact()
					+ " for Rs." + planPrice + " is Successful. <br><br> " + "Order Id: " + rechargeT.getRecargeId()
					+ "<br>Thanks for Recharging on Mobile Recharge.<br><br><br> We hope to see you again soon!, <br> Mobile Recharge. </h3>";
			try {
				mailService.sendMail(toEmail1, subject1, message1);
			} catch (MessagingException e) {
				e.printStackTrace();
			}

			customerRepo.save(customer);
		}

		try {

			mailService.sendMail(toEmail, subject, message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Plans> showPlans() {
		List<Plans> planList = plansRepo.findAll();
		if (planList.isEmpty()) {
			throw new PlansException("NO Plans Avaliable");
		}

		return planList;
	}

	@Override
	public Customer updateStatus(Long customerId) {
		Customer customer = customerRepo.getOne(customerId);
		customer.setAccountStatus("Verified");
		customerRepo.save(customer);
		return customer;
	}

	@Override
	public List<WalletHistory> showWalletHistory(Long customerId) {
		List<WalletHistory> walletHistory = walletHistoryRepo.findByCustomerId(customerId);
		if (walletHistory.isEmpty()) {
			throw new WalletHistoryException("No Transaction");
		}
		return walletHistory;
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		return customerRepo.save(customer);
	}

}
