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
@Table(name="Admin_Table")
public class Admin {
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
		@Column(name="Admin_id")
		private Long adminId;
		@Column(name="admin_Password")
		private String adminPassword="";
		@Column(name="admin_Name")
		private String AdminName="";
		
		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Admin(Long adminId, String adminPassword, String adminName) {
			super();
			this.adminId = adminId;
			this.adminPassword = adminPassword;
			AdminName = adminName;
		}

		public Long getAdminId() {
			return adminId;
		}

		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}

		public String getAdminPassword() {
			return adminPassword;
		}

		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}

		public String getAdminName() {
			return AdminName;
		}

		public void setAdminName(String adminName) {
			AdminName = adminName;
		}

		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", AdminName=" + AdminName + "]";
		}
		
}

