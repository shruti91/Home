
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test09_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Dry Iron");
		Category category=new Category();
		category.setCategoryId(5);
		category.setCategoryName("Home Appl");
		
		item.setCategory(category);
		item.setItemDescription("Philips HI 144 Ceralon Coating Dry Iron");
		item.setPrice(789);
		item.setStock(152);
		item.setImagePath("Iron.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("Weight", "0.9 Kg");
		map.put("Voltage","240 V");
		map.put("Power","1000 W");
		map.put("Sole Plate","Golden American Heritage");
		
	//	item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
