package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.pojo.Address;
import com.shopping.pojo.Customer;
import com.shopping.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	public CustomerService getCustService() {
		return custService;
	}
	public void setCustService(CustomerService custService) {
		this.custService = custService;
	}
	
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		Customer customer=new Customer();
		customer.setCustName(request.getParameter("txtName"));
		customer.setPhoneNo(Long.parseLong(request.getParameter("txtPhone")));
		
		Address address = new Address();
		address.setFlatNo(Integer.parseInt(request.getParameter("txtflatNo")));
		address.setStreet(request.getParameter("txtStreet"));
		address.setCity(request.getParameter("txtCity"));
		address.setPincode(Integer.parseInt(request.getParameter("txtPincode")));
		address.setState(request.getParameter("txtState"));
		address.setCountry(request.getParameter("txtCountry"));
		
		customer.setAddress(address);
		customer.setEmailId(request.getParameter("txtEmailId"));
		customer.setPassword(request.getParameter("txtPassword"));
		customer.setRole("customer");
		
		custService.addCustomer(customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customer",customer);
		mav.setViewName("Home");
		return mav;
	}
	
}
