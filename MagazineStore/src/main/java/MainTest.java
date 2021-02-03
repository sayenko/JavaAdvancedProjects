import java.time.Instant;
import java.util.Date;

import ua.com.magazine_store.domain.Bucket;
import ua.com.magazine_store.domain.Product;
import ua.com.magazine_store.domain.User;
import ua.com.magazine_store.service.BucketService;
import ua.com.magazine_store.service.ProductService;
import ua.com.magazine_store.service.UserService;
import ua.com.magazine_store.service.impl.BucketServiceImpl;
import ua.com.magazine_store.service.impl.ProductServiceImpl;
import ua.com.magazine_store.service.impl.UserServiceImpl;

public class MainTest {
	
	public static void main(String[] args) {
		
		System.out.println("\n--------------User implemintation--------------\n");
		
		UserService userService = UserServiceImpl.getUserService();
		userService.create(new User("test1@test", "test1", "test1", "USER", "test1"));
		userService.create(new User("test2@test", "test2", "test2", "USER", "test2"));
		userService.create(new User("test3@test", "test3", "test3", "USER", "test3"));
		userService.create(new User("test4@test", "test4", "test4", "USER", "test4"));
		userService.create(new User("test5@test", "test5", "test5", "USER", "test5"));
		userService.create(new User("user@email", "test6", "test6", "USER", "user@email"));
		userService.update(new User(1, "admin@email", "testFirstName", "testLastName", "ADMINISTRATOR", "admin@email"));
		userService.delete(3);
		System.out.println(userService.read(2));
		System.out.println("-----------------------------------------------");
		userService.readAll().forEach(System.out::println);		
		
		System.out.println("\n------------Product implemintation-------------\n");
		
		ProductService productService = ProductServiceImpl.getProductService();
		productService.create(new Product("milk", "decsription milk", 150.50));
		productService.create(new Product("water", "decsription water", 250.50));
		productService.create(new Product("bread", "decsription bread", 350.50));
		productService.create(new Product("apple", "decsription apple", 150.50));
		productService.create(new Product("banana", "decsription banana", 250.50));
		productService.create(new Product("meat", "decsription meat", 350.50));
		productService.update(new Product(2, "chocolate", "decsription chocolate", 160.25));
		productService.delete(3);
		System.out.println(productService.read(2));
		System.out.println("-----------------------------------------------");
		productService.readAll().forEach(System.out::println);
		
		System.out.println("\n-------------Bucket implemintation-------------\n");
		
		BucketService bucketService = BucketServiceImpl.getBucketService();
		bucketService.create(new Bucket(1, 1, Date.from(Instant.now())));
		bucketService.create(new Bucket(2, 2, Date.from(Instant.now())));
		bucketService.create(new Bucket(5, 6, Date.from(Instant.now())));
		bucketService.create(new Bucket(6, 5, Date.from(Instant.now())));
		bucketService.create(new Bucket(4, 6, Date.from(Instant.now())));
		bucketService.create(new Bucket(2, 2, Date.from(Instant.now())));		
		bucketService.delete(3);
		System.out.println(bucketService.read(2));
		System.out.println("-----------------------------------------------");
		bucketService.readAll().forEach(System.out::println);
	}
}
