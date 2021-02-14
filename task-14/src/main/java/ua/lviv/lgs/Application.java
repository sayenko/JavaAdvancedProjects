package ua.lviv.lgs;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Cart cart = new Cart(4, "Big Cart");
		Item item1 = new Item(1);
		Item item2 = new Item(2);
		Item item3 = new Item(3);
		Item item4 = new Item(4);
		
		cart.setItems(new HashSet<Item>(Arrays.asList(item1, item2, item3, item4)));
		session.persist(cart);		
		
		transaction.commit();
		session.close();

	}

}
