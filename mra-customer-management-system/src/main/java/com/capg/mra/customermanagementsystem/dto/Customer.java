package com.capg.mra.customermanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Boola Rohan
 * @author Sumani
 *
 */
/**
 * The @Entity annotation specifies that the class is an entity and is mapped to a database table.
 * inside package of  javax.persistence.Entity
 *
 */
@Entity
/**
 * 
 * The @Table annotation specifies the name of the database table to be used for mapping.
 * inside package of javax.persistence.Table
 */
@Table(name="Customer_Table")
public class Customer {
	
	    
	    /**
	     * This annotation is declared to determine where the 
	     * primary key attribute of the entity corresponds to 
	     * the primary key column in the table.
	     */
		@Id
		/**
		 * The GeneratedValue annotation may be applied to a primary key property or 
		 * field of an entity or mapped superclass in conjunction with the Id annotation. 
		 * The use of the GeneratedValue annotation is only required to be supported for simple primary keys.
		 * 
		 */
		@GeneratedValue(strategy=GenerationType.AUTO)
	    /**
	     * Is used to specify the mapped column for a persistent property or field. 
	     * If no Column annotation is specified, the default values apply.
	     */	
		@Column(name="Customer_id")
		private Long customerId;
		@Column(name="Customer_Name")
		private String customerName;
		@Column(name="Customer_Contact")
		private String customerContact;
		@Column(name="Customer_Email")
		private String customerEmail;
		@Column(name="Customer_Plan")
		private int customerPlan;
		@Column(name="Customer_PlanDate")
		private String planDate;
		@Column(name="Customer_Wallet")
		private double customerWallet;
		@Column(name="Customer_Password")
		private String customerPassword;
		@Column(name="Account_Status")
		private String accountStatus;
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customer(Long customerId, String customerName, String customerContact, String customerEmail,
				int customerPlan, String planDate, double customerWallet, String customerPassword, String accountStatus) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerContact = customerContact;
			this.customerEmail = customerEmail;
			this.customerPlan = customerPlan;
			this.planDate = planDate;
			this.customerWallet = customerWallet;
			this.customerPassword = customerPassword;
			this.accountStatus = accountStatus;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerContact() {
			return customerContact;
		}
		public void setCustomerContact(String customerContact) {
			this.customerContact = customerContact;
		}
		public String getCustomerEmail() {
			return customerEmail;
		}
		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}
		public int getCustomerPlan() {
			return customerPlan;
		}
		public void setCustomerPlan(int customerPlan) {
			this.customerPlan = customerPlan;
		}
		public String getPlanDate() {
			return planDate;
		}
		public void setPlanDate(String planDate) {
			this.planDate = planDate;
		}
		public double getCustomerWallet() {
			return customerWallet;
		}
		public void setCustomerWallet(double customerWallet) {
			this.customerWallet = customerWallet;
		}
		public String getCustomerPassword() {
			return customerPassword;
		}
		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}
		public String getAccountStatus() {
			return accountStatus;
		}
		public void setAccountStatus(String accountStatus) {
			this.accountStatus = accountStatus;
		}
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerContact="
					+ customerContact + ", customerEmail=" + customerEmail + ", customerPlan=" + customerPlan
					+ ", planDate=" + planDate + ", customerWallet=" + customerWallet + ", customerPassword="
					+ customerPassword + ", accountStatus=" + accountStatus + "]";
		}	

		

}

