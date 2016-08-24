import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Admin;


public class Test11_AddAdmin {
	
	public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	
	Admin admin=new Admin();
	admin.setUserName("admin");
	admin.setPassword("admin");
	admin.setRole("admin");
	
	session.save(admin);
	
	tx.commit();
	session.close();
	}
}
