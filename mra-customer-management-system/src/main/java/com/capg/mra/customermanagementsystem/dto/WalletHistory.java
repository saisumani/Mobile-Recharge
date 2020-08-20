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
@Table(name = "WalletHistory_Table")
public class WalletHistory {
        
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
		@Column(name = "MobileRecahrge_Id")
		private Long walletId;
		@Column(name = "Customer_Id")
		private Long customerId;
		@Column(name = "MobileRecahrge_Amout")
		private Double walletAmount;
		@Column(name = "MobileRecahrge_Type")
		private String type;
		@Column(name = "MobileRecahrge_DateTime")
		private String dateTime;

		public WalletHistory() {
			// TODO Auto-generated constructor stub
		}

		public WalletHistory(Long walletId, Long customerId, Double amount, String type, String dateTime) {
			super();
			this.walletId = walletId;
			this.customerId = customerId;
			this.walletAmount = walletAmount;
			this.type = type;
			this.dateTime = dateTime;
		}

		public Long getWalletId() {
			return walletId;
		}

		public void setWalletId(Long walletId) {
			this.walletId = walletId;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public Double getWalletAmount() {
			return walletAmount;
		}

		public void setAmount(Double walletAmount) {
			this.walletAmount = walletAmount;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}

		@Override
		public String toString() {
			return "WalletHistory [walletId=" + walletId + ", customerId=" + customerId + ", walletAmount=" + walletAmount
					+ ", type=" + type + ", dateTime=" + dateTime + "]";
		}

}

