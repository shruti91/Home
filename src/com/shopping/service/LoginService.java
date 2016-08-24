package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.UserDAO;
import com.shopping.pojo.Admin;
import com.shopping.pojo.Customer;

@Service("loginservice")
public class LoginService {
	
	@Autowired
	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public Customer login(String emailId, String password){
		return userDao.login(emailId, password);	
	}
	
	public Admin loginAdmin(String emailId, String password){
		return userDao.loginAdmin(emailId, password);	
	}
}


