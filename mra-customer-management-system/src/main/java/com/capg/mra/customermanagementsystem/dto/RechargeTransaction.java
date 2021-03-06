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
@Table(name = "Recharge_Transactions_Table")
public class RechargeTransaction {
        
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
		@GeneratedValue(strategy = GenerationType.AUTO)
		/**
		 * Is used to specify the mapped column for a persistent property or field. 
		 * If no Column annotation is specified, the default values apply.
		 */
		@Column(name = "Recharge_id")
		private Long rechargeId;
		@Column(name = "Customer_id")
		private Long customerId;
		@Column(name = "Mobile_Number")
		private String mobileNumber;
		@Column(name = "Recharge_Name")
		private String rechargeName;
		@Column(name = "Recharge_Price")
		private Long rechargePrice;
		@Column(name = "Recharge_Validity")
		private Integer rechargeValidity;
		@Column(name = "Recahrge_TxTime")
		private String transactionDateTime;
		@Column(name = "Operator")
		private String operator;
		@Column(name = "Circle")
		private String circle;

		public RechargeTransaction() {
			// TODO Auto-generated constructor stub
		}

		public RechargeTransaction(Long recargeId, Long customerId, String mobileNumber, String rechargeName,
				Long rechargePrice, Integer rechargeValidity, String transactionDateTime, String operator, String circle) {
			super();
			this.rechargeId = recargeId;
			this.customerId = customerId;
			this.mobileNumber = mobileNumber;
			this.rechargeName = rechargeName;
			this.rechargePrice = rechargePrice;
			this.rechargeValidity = rechargeValidity;
			this.transactionDateTime = transactionDateTime;
			this.operator = operator;
			this.circle = circle;
		}

		public Long getRecargeId() {
			return rechargeId;
		}

		public void setRecargeId(Long recargeId) {
			this.rechargeId = recargeId;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getRechargeName() {
			return rechargeName;
		}

		public void setRechargeName(String rechargeName) {
			this.rechargeName = rechargeName;
		}

		public Long getRechargePrice() {
			return rechargePrice;
		}

		public void setRechargePrice(Long rechargePrice) {
			this.rechargePrice = rechargePrice;
		}

		public Integer getRechargeValidity() {
			return rechargeValidity;
		}

		public void setRechargeValidity(Integer rechargeValidity) {
			this.rechargeValidity = rechargeValidity;
		}

		public String getTransactionDateTime() {
			return transactionDateTime;
		}

		public void setTransactionDateTime(String transactionDateTime) {
			this.transactionDateTime = transactionDateTime;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public String getCircle() {
			return circle;
		}

		public void setCircle(String circle) {
			this.circle = circle;
		}

		@Override
		public String toString() {
			return "RechargeTransaction [recargeId=" + rechargeId + ", customerId=" + customerId + ", mobileNumber="
					+ mobileNumber + ", rechargeName=" + rechargeName + ", rechargePrice=" + rechargePrice
					+ ", rechargeValidity=" + rechargeValidity + ", transactionDateTime=" + transactionDateTime
					+ ", operator=" + operator + ", circle=" + circle + "]";
		}


}
