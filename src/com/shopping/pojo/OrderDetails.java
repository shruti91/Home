package com.shopping.pojo;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetails {

	private double serviceTax;
	private double vat;
	private double discountRate;
	private double finalAmount;
	public double getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	@Override
	public String toString() {
		return "OrderDetails [serviceTax=" + serviceTax + ", vat=" + vat
				+ ", discountRate=" + discountRate + ", finalAmount="
				+ finalAmount + "]";
	}
}
