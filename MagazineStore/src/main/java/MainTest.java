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
		userService.create(new User("admin@admin.com", "admin@admin.com", "admin@admin.com", "ADMINISTRATOR", "admin@admin.com"));
		userService.create(new User("first_user@user.com", "first_user@user.com", "first_user@user.com", "USER", "first_user@user.com"));
		userService.create(new User("second_user@user.com", "second_user@user.com", "second_user@user.com", "USER", "second_user@user.com"));
//		userService.update(new User(1, "admin@email", "testFirstName", "testLastName", "ADMINISTRATOR", "admin@email"));
//		userService.delete(3);
//		System.out.println(userService.read(2));
//		System.out.println("-----------------------------------------------");
//		userService.readAll().forEach(System.out::println);		
//		
//		System.out.println("\n------------Product implemintation-------------\n");
//		
		ProductService productService = ProductServiceImpl.getProductService();
		productService.create(new Product("milk", "decsription milk", 150.50));
		productService.create(new Product("water", "decsription water", 250.50));
		productService.create(new Product("bread", "decsription bread", 350.50));
		productService.create(new Product("apple", "decsription apple", 150.50));
		productService.create(new Product("banana", "decsription banana", 250.50));
		productService.create(new Product("meat", "decsription meat", 350.50));
//		productService.update(new Product(2, "chocolate", "decsription chocolate", 160.25));
//		productService.delete(3);
//		System.out.println(productService.read(2));
//		System.out.println("-----------------------------------------------");
//		productService.readAll().forEach(System.out::println);
	}
}
