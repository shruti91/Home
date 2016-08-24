
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test07_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Grill Maker");
		Category category=new Category();
		category.setCategoryId(4);
		category.setCategoryName("Kitchen Appl");
		
		item.setCategory(category);
		item.setItemDescription("Nova 2 slice Panini Grill Maker");
		item.setPrice(2000);
		item.setStock(42);
		item.setImagePath("Grill_Maker.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("Function", "Toasting & Grilling");
		map.put("Slice Capacity","2");
		map.put("Dispaly Function","Grilling");
		map.put("Power Consumption","750 W");
		
		//item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
