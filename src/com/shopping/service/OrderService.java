package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDAO;
import com.shopping.pojo.Customer;
import com.shopping.pojo.OrderMaster;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	
	public List<OrderMaster> viewAllOrder(Customer customer){
		return orderDao.viewAllOrder(customer);
	}
	
	public OrderMaster getOrderById(int orderId){
		return orderDao.getOrderById(orderId);
	}

	public List<OrderMaster>  viewAllOrderAdmin(){
		return orderDao.viewAllOrderAdmin();
	}
	
	public void dispatchOrder(int orderId){
		orderDao.dispatchOrder(orderId);
	}
	
}
