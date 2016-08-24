package com.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shopping.pojo.Feedback;
import com.shopping.pojo.ItemMaster;

@Repository
public class FeedbackDAO {
	
	public List<Feedback> allFeedback(){
	
	SessionFactory factory = new Configuration().configure()
			.buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	
	Query query =  session.createQuery("from Feedback");
	List<Feedback> allFeedback = query.list();
	System.out.println(allFeedback);
	
	tx.commit();
	session.close();
	return allFeedback;

	}

	public void addFeedback(Feedback feedback) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
	
		session.save(feedback);
		
		tx.commit();
		session.close();
	}
	
}