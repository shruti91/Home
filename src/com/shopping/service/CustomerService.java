package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.CustomerDAO;
import com.shopping.pojo.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO custDao;
	
	public CustomerDAO getCustDao() {
		return custDao;
	}
	public void setCustDao(CustomerDAO custDao) {
		this.custDao = custDao;
	}
	
	public void addCustomer(Customer customer){
		custDao.addCustomer(customer);
	}
	
	
}
