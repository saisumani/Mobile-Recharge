package com.capg.mra.adminmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Table")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
