
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test05_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Titan");
		Category category=new Category();
		
		category.setCategoryId(3);
		category.setCategoryName("Watches");
		
		item.setCategory(category);
		item.setItemDescription("Titan 2539M01 Raga Analog Watch");
		item.setPrice(3000);
		item.setStock(58);
		item.setImagePath("Titan.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("Mechanism", "Quartz");
		map.put("Type","Analog");
		map.put("Series","Raga");
		map.put("Style-Code","2539SM01");
		map.put("Ideal for","Women");
		
	//	item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
