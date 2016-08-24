package com.shopping.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private int flatNo;
	@Column(length=15)
	private String city;
	@Column(length=20)
	private String Street;
	private int pincode;
	@Column(length=25)
	private String state;
	@Column(length=25)
	private String country;
	
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", city=" + city + ", Street="
				+ Street + ", pincode=" + pincode + "]";
	}
}
