package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shopping.pojo.Admin;
import com.shopping.pojo.Customer;
import com.shopping.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController extends MultiActionController{
	
	@Autowired
	private LoginService loginservice;
	
	public LoginService getLoginservice() {
		return loginservice;
	}

	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}

	@RequestMapping("/authenticateCust")
	public ModelAndView authenticateCust(HttpServletRequest request,
			HttpServletResponse response) {
		//String role=request.getParameter("role");
		String emailId=request.getParameter("txtUser");
		String password=request.getParameter("txtPassword");
		
		System.out.println("Email Id is ::"+emailId);
		System.out.println("Password is ::"+password);
		
		Customer customer = loginservice.login(emailId, password);
		
		System.out.println("Customer inside Login is "+customer);
		
		HttpSession session=request.getSession();
		session.setAttribute("user", customer);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customer", customer);
		mav.setViewName("Index");
		return mav;
	}
	
	@RequestMapping("/authenticateAdmin")
	public ModelAndView authenticateAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		//String role=request.getParameter("role");
		String emailId=request.getParameter("txtUser");
		String password=request.getParameter("txtPassword");
		
		System.out.println("Email Id is ::"+emailId);
		System.out.println("Password is ::"+password);
		
		Admin admin = loginservice.loginAdmin(emailId, password);
		
		System.out.println("Admin inside Login is "+admin);
		
		HttpSession session=request.getSession();
		session.setAttribute("user", admin);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("admin", admin);
		mav.setViewName("Index");
		return mav;
		
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Index");
		return mav;
	}
}
