
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test01_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Lenovo");
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("Mobile");
		
		item.setCategory(category);
		item.setItemDescription("Lenovo A7000");
		item.setPrice(699);
		item.setStock(102);
		item.setImagePath("Lenovo.jpg");
		Map<String, String> map=new HashMap<>();
		map.put("SimCard", "Dual Sim");
		map.put("Camera","8MP");
		map.put("Length","5.5-inch");
		map.put("OS","LollyPop");
		
		//item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
