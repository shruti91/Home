
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Category;
import com.shopping.pojo.ItemMaster;


public class Test03_ProductManagement {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		ItemMaster item=new ItemMaster();
		item.setItemName("Football");
		
		Query query = session
				.createQuery("from Category c where c.categoryId=?");
		query.setInteger(0, 2);
		Category category=(Category) query.uniqueResult();
		
		category.setCategoryName(category.getCategoryName());
		
		item.setCategory(category);
		item.setItemDescription("Head Titanium 3100 Club Series Tennis Racquet");
		item.setPrice(399);
		item.setStock(120);
		item.setImagePath("football.png");
		Map<String, String> map=new HashMap<>();
		map.put("ShipingWeight", "1 Pound");
		map.put("Length","30 Centimeters");
		map.put("Width","30 Centimeters");
		map.put("Material-Type","rubber");
		
	//	item.setSpecification(map);
		
		session.save(item);

		tx.commit();
		session.close();
	}

}
