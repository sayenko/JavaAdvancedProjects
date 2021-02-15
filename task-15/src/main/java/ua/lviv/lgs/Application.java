package ua.lviv.lgs;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post = new Post("FakeNews post");

		Comment comment1 = new Comment("Bot_2019");
		comment1.setPost(post);
		
		Comment comment2 = new Comment("new Bot");
		comment2.setPost(post);
		
		Comment comment3 = new Comment("Bot_45");
		comment3.setPost(post);

		Set<Comment> comments = new HashSet<>();
		comments.add(comment1);
		comments.add(comment2);
		comments.add(comment3);
		
		post.setComments(comments);

		Transaction transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();

		Post postDB = (Post) session.get(Post.class, 1);
		System.out.println(postDB + "---->" + postDB.getComments());

		Comment commentDB = (Comment) session.get(Comment.class, 2);
		System.out.println(commentDB + "---->" + commentDB.getPost());

	}
}
