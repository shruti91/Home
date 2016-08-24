
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test06_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Casio");
		
		Query query = session
				.createQuery("from Category c where c.categoryId=?");
		query.setInteger(0, 3);
		Category category=(Category) query.uniqueResult();
		
		category.setCategoryName(category.getCategoryName());
		
		item.setCategory(category);
		item.setItemDescription("Casio 1251bm02 Analog Watch");
		item.setPrice(4000);
		item.setStock(99);
		item.setImagePath("Casio.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("Mechanism", "Quartz");
		map.put("Type","Analog");
		map.put("Style-Code","1251bm02");
		map.put("Ideal for","Men");
		
		//item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
