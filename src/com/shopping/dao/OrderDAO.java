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
import com.shopping.pojo.OrderMaster;

@Repository
public class OrderDAO {

	public void addOrder(OrderMaster orderMaster) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(orderMaster);

		tx.commit();
		session.close();
	}

	public List<OrderMaster> viewAllOrder(Customer customer) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("from OrderMaster o where o.customer.custId=?");
		query.setInteger(0, customer.getCustId());
		List<OrderMaster> orderList = (List<OrderMaster>) query.list();
		System.out.println("OrderList of Customer :: " + customer.getCustName()
				+ " is :: " + orderList);
		tx.commit();
		session.close();

		return orderList;
	}

	public OrderMaster getOrderById(int orderId) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("from OrderMaster o where o.orderId=?");
		query.setInteger(0, orderId);
		OrderMaster orderMaster = (OrderMaster) query.uniqueResult();
		System.out.println("OrderList of Customer :: " + orderMaster);

		tx.commit();
		session.close();

		return orderMaster;
	}
	
	public List<OrderMaster>  viewAllOrderAdmin(){
		
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("from OrderMaster");
		
		List<OrderMaster> orderList = (List<OrderMaster>) query.list();

		tx.commit();
		session.close();
		return orderList;
	}
	
	
public void dispatchOrder(int orderId){
		
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("from OrderMaster o where o.orderId=?");
		query.setInteger(0, orderId);
		OrderMaster orderMaster = (OrderMaster) query.uniqueResult();
		System.out.println("OrderList of Customer :: " + orderMaster);
		
		orderMaster.setOrderStatus("Dispatched");
		orderMaster.setPaymentStatus("Paid");
		session.update(orderMaster);
		
		tx.commit();
		session.close();
	
	}
	
	
}
