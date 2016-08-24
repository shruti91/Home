package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CustomerDAO;
import com.shopping.pojo.Customer;
import com.shopping.pojo.ItemMaster;
import com.shopping.pojo.OrderMaster;
import com.shopping.service.CartService;
import com.shopping.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	//CustomerDAO custDao=new CustomerDAO();
	
	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Autowired
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/placeOrder")
	public ModelAndView placeOrder(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		System.out.println("Login Customer is :: "+ customer);
		
		//Customer customer=custDao.searchCustomerById(customer.getCustId());
		
		OrderMaster orderMaster = cartService.checkOut(customer);
		ModelAndView mav = new ModelAndView();
		mav.addObject("orderMaster", orderMaster);
		mav.setViewName("order");
		return mav;
	}
	
	@RequestMapping("/viewAllOrder")
	public ModelAndView viewAllOrder(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		
		List<OrderMaster> orderList=orderService.viewAllOrder(customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("OrderMaster", orderList);
		mav.setViewName("ViewOrder");
		return mav;
	}
	
	@RequestMapping("/viewOrderItem")
	public ModelAndView viewOrderItem(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderMaster orderMaster=orderService.getOrderById(orderId);
		
		System.out.println("Order is :: (in order Controller)" +orderMaster);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("OrderMaster", orderMaster);
		mav.setViewName("ViewOrderItem");
		return mav;
	}
	
	@RequestMapping("/viewAllOrderAdmin")
	public ModelAndView viewAllOrderAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<OrderMaster> orderList=orderService.viewAllOrderAdmin();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("OrderMaster", orderList);
		mav.setViewName("ViewOrderAdmin");
		return mav;
	}
	
	@RequestMapping("/dispatchOrder")
	public ModelAndView dispatchOrder(HttpServletRequest request,
			HttpServletResponse response) {
		
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		orderService.dispatchOrder(orderId);
		List<OrderMaster> orderList=orderService.viewAllOrderAdmin();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("OrderMaster", orderList);
		mav.setViewName("ViewOrderAdmin");
		return mav;
	}
	
}
