
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Address;
import com.shopping.pojo.Customer;

public class Test01_CustomerManagement02 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Customer customer=new Customer();
		customer.setCustName("Stefan");
		
		Address address=new Address();
		address.setFlatNo(145);
		address.setStreet("LBS STREET");
		address.setCity("MUMBAI-NAVI");
		address.setPincode(400078);
		
		customer.setAddress(address);
		
		//Users user=new Users();
		customer.setEmailId("stefan@gmail.com");
		customer.setPassword("stefan");
		customer.setRole("customer");
		
		session.save(customer);
		
		tx.commit();
		session.close();
	}

}
