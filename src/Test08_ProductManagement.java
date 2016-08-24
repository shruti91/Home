
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test08_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Microwave Oven");
		Query query = session
				.createQuery("from Category c where c.categoryId=?");
		query.setInteger(0, 4);
		Category category=(Category) query.uniqueResult();
		
		category.setCategoryName(category.getCategoryName());
		
		item.setCategory(category);
		item.setItemDescription("LG MC255SMP 28L Convection Microwave Oven");
		item.setPrice(7099);
		item.setStock(15);
		item.setImagePath("Microwave.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("Type", "Convection");
		map.put("Capacity","28 L");
		map.put("Turnable Diameter","32 cm");
		map.put("Power Output","900 W");
		
	//	item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
