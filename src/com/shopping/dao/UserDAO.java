package com.shopping.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shopping.pojo.Admin;
import com.shopping.pojo.Customer;

@Repository
public class UserDAO {
	
	public Customer login(String emailId, String password){
		
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query =  session.createQuery(
				"from Customer c where c.emailId=? and c.password=?");
		query.setString(0, emailId);
		query.setString(1, password);
		
		Customer customer = (Customer) query.uniqueResult();
		
		System.out.println("Customer Inside UserDao is :: "+customer);
		
		tx.commit();
		session.close();
		
		return customer;
	}
	
	public Admin loginAdmin(String emailId, String password){
		
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query =  session.createQuery(
				"from Admin a where a.userName=? and a.password=?");
		query.setString(0, emailId);
		query.setString(1, password);
		
		Admin admin = (Admin) query.uniqueResult();
		
		System.out.println("Customer Inside UserDao is :: "+admin);
		
		tx.commit();
		session.close();
		
		return admin;
	}
	
}
