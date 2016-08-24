package com.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shopping.pojo.Customer;
import com.shopping.pojo.ItemMaster;

@Repository
public class CustomerDAO {
	
	public List<Customer> getAllCustomers(){
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query queryForAllCustomer = session.createQuery("from Customer");
		List<Customer> allCustomers = queryForAllCustomer.list();
		System.out.println(allCustomers);

		tx.commit();
		session.close();
		return allCustomers;
	}
	
	public Customer searchCustomerById(int custId){
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query queryForAllCustomer = session.createQuery("from Customer");
		Customer customer = (Customer) session.get(Customer.class, custId);
		System.out.println(customer);

		tx.commit();
		session.close();
		return customer;
	}
	
	public void addCustomer(Customer customer){
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(customer);

		tx.commit();
		session.close();
	}
	
	
}
