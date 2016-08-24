package com.shopping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shopping.pojo.Category;

@Repository
public class CategoryDAO {


	public void addCategory(String catName){
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Category category=new Category();
		category.setCategoryName(catName);
		
		session.save(category);
		
		tx.commit();
		session.close();
	}
	
}
