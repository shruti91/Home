
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test04_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Moto G");
		
		Query query = session
				.createQuery("from Category c where c.categoryId=?");
		query.setInteger(0, 1);
		
		Category category=(Category) query.uniqueResult();
		
		category.setCategoryName(category.getCategoryName());
		
		item.setCategory(category);
		item.setItemDescription("Moto-G: Black, with 16 GB");
		item.setPrice(11000);
		item.setStock(69);
		item.setImagePath("Motorola.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("SimCard", "Dual Sim");
		map.put("Camera","13MP");
		map.put("Length","12.7-cm");
		map.put("OS","KitKat");
		
	//	item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
