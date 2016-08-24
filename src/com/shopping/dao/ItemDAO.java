package com.shopping.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.internal.runtime.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;

@Repository
public class ItemDAO {

	public List<ItemMaster> getAllItems() {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query queryForAllItems = session.createQuery("from ItemMaster");
		List<ItemMaster> allItems = queryForAllItems.list();
		System.out.println(allItems);

		tx.commit();
		session.close();
		return allItems;
	}
	
	public void addItems(ItemMaster item){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(item);
		
		tx.commit();
		session.close();
	}
	
	public void removeItem(int itemId){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query =  session.createQuery("from ItemMaster i where i.itemId=?");
		query.setInteger(0, itemId);
		ItemMaster item = (ItemMaster) query.uniqueResult();
		
		Category category=item.getCategory();
		Set<ItemMaster> itemSet=category.getItem();
		for (Iterator iterator = itemSet.iterator(); iterator.hasNext();) {
			ItemMaster itemMaster = (ItemMaster) iterator.next();
			if(itemMaster.equals(item)){
				iterator.remove();
			}
		}
		
		item.setCategory(null); 
		
		//session.save(category);
		
		session.delete(item);
		
		
		tx.commit();
		session.close();
	}
	
	public ItemMaster searchById(int itemId){
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=(ItemMaster) session.get(ItemMaster.class, itemId);
				
		tx.commit();
		session.close();
		
		return item;
	}
	
	public List<ItemMaster> searchByCategory(String catName){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
	System.out.println(catName);
		Query queryForAllProducts = session.createQuery("from Category where categoryName=?").setString(0,catName);
		Category c = (Category) queryForAllProducts.uniqueResult();
		List<ItemMaster> list = new ArrayList<>();
		int catId = c.getCategoryId();
		System.out.println("Category ID is lets c: "+catId);
		Query query = session.createQuery("from ItemMaster");
		List<ItemMaster> listCategory = query.list();
		System.out.println("List is:"+listCategory);
		System.out.println("List is :: "+listCategory);
		
		for (ItemMaster item : listCategory) {
			System.out.println("Category Id is :: "+ item.getCategory().getCategoryId());
			if(item.getCategory().getCategoryId()==catId)
			{
				list.add(item);
			}
		}
		return list;
	}

}
