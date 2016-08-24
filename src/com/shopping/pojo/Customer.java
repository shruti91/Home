package com.shopping.pojo;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTTID")
	private int custId;
	
	@Column(length=30)
	private String custName;
	
	@Embedded
	private Address address;
	/*
	@Embedded
	private Users users;*/
	
	@Column(length=30)
	private String emailId;
	@Column(length=30)
	private String password;
	
	
	@OneToMany
	private Set<OrderMaster> orderMaster;
	
	@Transient
	private long phoneNo;
	
	@Column(length=15)
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<OrderMaster> getOrderMaster() {
		return orderMaster;
	}
	
	public void setOrderMaster(Set<OrderMaster> orderMaster) {
		this.orderMaster = orderMaster;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", address=" + address + ", emailId=" + emailId
				+ ", password=" + password + ", phoneNo=" + phoneNo + ", role="
				+ role + "]";
	}
	
	
}
