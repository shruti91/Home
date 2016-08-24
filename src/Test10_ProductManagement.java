
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test10_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Gas Stove");
		Query query = session
				.createQuery("from Category c where c.categoryId=?");
		query.setInteger(0, 5);
		Category category=(Category) query.uniqueResult();
		
		category.setCategoryName(category.getCategoryName());
		
		item.setCategory(category);
		item.setItemDescription("Pigeon PipeLine Smart Gas Stove");
		item.setPrice(3690);
		item.setStock(200);
		item.setImagePath("Gas.png");
		Map<String, String> map=new HashMap<>();
		map.put("Weight", "3 Kg");
		map.put("Color","Black");
		map.put("Efficiency","High Thermal");
		map.put("No. of Burners","3");
		
	//	item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
