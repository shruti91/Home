package com.shopping.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDAO;
import com.shopping.model.Cart;
import com.shopping.pojo.Customer;
import com.shopping.pojo.ItemMaster;
import com.shopping.pojo.OrderMaster;

@Service("cartService")
public class CartService {
	
	Cart cart=new Cart();
	
	@Autowired
	private OrderDAO orderDao;
	
	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	public void addToCart(ItemMaster item,int quantity){
		cart.UpdateCart(item, quantity);
	}
	
	public void removeCart(ItemMaster item){
		cart.removeCart(item);
	}
	
	public Map<ItemMaster,Integer> viewAllCart(){
		return cart.viewAllCartItemsMap();
	}
	
	public OrderMaster checkOut(Customer customer){
		OrderMaster orderMaster= cart.placeOrder(customer);
		orderDao.addOrder(orderMaster);
		cart.deletCart();
		return orderMaster;
	}
	
	
}
