
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test02_ProductManagement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("BasketBall");
		Category category=new Category();
		category.setCategoryId(2);
		category.setCategoryName("Sports");
		
		item.setCategory(category);
		item.setItemDescription("Head Titanium 3100 Club Series Tennis Racquet");
		item.setPrice(599);
		item.setStock(50);
		item.setImagePath("basketball.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("ShipingWeight", "2 Pound");
		map.put("Length","40 Centimeters");
		map.put("Width","40 Centimeters");
		map.put("Material-Type","rubber");
		
		//item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
