import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shopping.pojo.Address;
import com.shopping.pojo.Customer;


public class Test01_CustomerManagement01 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Customer customer=new Customer();
		customer.setCustName("Damon");
		
		Address address=new Address();
		address.setFlatNo(144);
		address.setStreet("LBS ROAD");
		address.setCity("MUMBAI");
		address.setPincode(400078);
		
		customer.setAddress(address);
		
		//Users user=new Users();
		customer.setEmailId("damon@gmail.com");
		customer.setPassword("damon");
		customer.setRole("customer");
		
		session.save(customer);
		
		tx.commit();
		session.close();

	}

}
