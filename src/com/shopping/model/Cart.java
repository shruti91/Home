package com.shopping.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shopping.pojo.Customer;
import com.shopping.pojo.ItemMaster;
import com.shopping.pojo.OrderDetails;
import com.shopping.pojo.OrderMaster;

public class Cart {

	Map<ItemMaster, Integer> cartMap;
	double discount = 10.0;
	double serviceTax = 12.5;
	double vat = 5.0;

	public Map<ItemMaster, Integer> getCartMap() {
		return cartMap;
	}
	/*public void addCartMap(ItemMaster itemMaster, int quantity) {
		getCartMap().put(itemMaster, quantity);
	}*/

	public void setCartMap(Map<ItemMaster, Integer> cartMap) {
		this.cartMap = cartMap;
	}


	public OrderMaster placeOrder(Customer customer) {
		OrderMaster orderMaster = new OrderMaster();
		OrderDetails orderDetails = new OrderDetails();
		
		Calendar calod = Calendar.getInstance();
		calod.setTime(new Date());
		Calendar caldd = Calendar.getInstance();
		caldd.setTime(new Date());	
		caldd.add(Calendar.DATE,7);
		

		/*SimpleDateFormat sdformat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = null;
try {
			
			date = sdformat.parse("20-05-2015");
			System.out.println("Date is :: "+date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		orderMaster.setCustomer(customer);
		orderMaster.setItems(cartMap);

		
		
		double totalPrice = calcTotalPrice();
		double finalAmount = calcFinalPrice(totalPrice);

		orderMaster.setDeliveryDate(caldd.getTime());
		orderMaster.setOrderDate(calod.getTime());
		orderMaster.setOrderStatus("Pending");
		orderMaster.setTotalPrice(totalPrice);
		orderMaster.setPaymentStatus("Pending payment");

		orderDetails.setDiscountRate(discount);
		orderDetails.setServiceTax(serviceTax);
		orderDetails.setVat(vat);
		orderDetails.setFinalAmount(finalAmount);

		orderMaster.setOrderDetails(orderDetails);

		return orderMaster;
	}
	
	/*public Map<ItemMaster, Integer> UpdateCart(ItemMaster item,int quantity){
		cartMap.put(item, quantity);
		System.out.println("Updated cartMap is :: "+cartMap);
		return cartMap;
	}*/
	
	public void UpdateCart(ItemMaster item, int quantity) {

		if (cartMap == null) {
			cartMap = new HashMap<>();
			cartMap.put(item, quantity);
			
		} else {
			if (cartMap.containsKey(item)) {
				int quantity1 = cartMap.get(item);
				quantity1++;
				cartMap.put(item, quantity1);
			} else {
				cartMap.put(item, quantity);
			}
		}
		System.out.println("Updated cartMap is :: " + cartMap);
	}
	
	public void removeCart(ItemMaster item){
		cartMap.remove(item);
	}

	public double calcTotalPrice() {
		Set<ItemMaster> itemKey = cartMap.keySet();
		double totalPrice = 0;
		for (ItemMaster item : itemKey) {
			double price = item.getPrice();
			int quantity = cartMap.get(item);
			totalPrice += (price * quantity);
		}

		System.out.println("TotalPrice :: " + totalPrice);
		return totalPrice;
	}

	public double calcFinalPrice(double totalPrice) {
		double discountAmount = (totalPrice * discount) / 100;
		double serviceAmount = (totalPrice * serviceTax) / 100;
		double vatAmount = (totalPrice * vat) / 100;

		double finalAmount = (totalPrice - discountAmount) + serviceAmount
				+ vatAmount;
		System.out.println(finalAmount);
		return finalAmount;
	}
	
	public Map<ItemMaster,Integer> viewAllCartItemsMap(){
		System.out.println(cartMap);
		return cartMap;
	}
	
	public List<ItemMaster> viewAllCartItems(){
		List<ItemMaster> allCartItems=new ArrayList<>();
		Set<ItemMaster> itemKey = cartMap.keySet();
		for (ItemMaster item : itemKey) {
			allCartItems.add(item);
		}
		System.out.println(allCartItems);
		return allCartItems;
	}
	
	public void deletCart(){
		setCartMap(null);
		System.out.println("Map after deleteing cart :: "+cartMap);
	}
	
	
	
}
