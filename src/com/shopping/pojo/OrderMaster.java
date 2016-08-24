package com.shopping.pojo;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ORDERMASTER")
public class OrderMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private Date orderDate;
	private Date deliveryDate;
	@Column(length=30)
	private String orderStatus;
	private double totalPrice;

	@ElementCollection
	private Map<ItemMaster,Integer> items;
	
	@Embedded
	private OrderDetails orderDetails;
	
	private String paymentStatus;
	
	@ManyToOne
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<ItemMaster, Integer> getItems() {
		return items;
	}

	public void setItems(Map<ItemMaster, Integer> items) {
		this.items = items;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "OrderMaster [orderId=" + orderId + ", orderDate=" + orderDate
				+ ", deliveryDate=" + deliveryDate + ", orderStatus="
				+ orderStatus + ", totalPrice=" + totalPrice + ", items="
				+ items + ", orderDetails=" + orderDetails + ", paymentStatus="
				+ paymentStatus + "]";
	}
}
