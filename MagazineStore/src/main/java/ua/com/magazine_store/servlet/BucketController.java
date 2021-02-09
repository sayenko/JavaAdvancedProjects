package ua.com.magazine_store.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.magazine_store.domain.Bucket;
import ua.com.magazine_store.domain.Product;
import ua.com.magazine_store.domain.User;
import ua.com.magazine_store.service.BucketService;
import ua.com.magazine_store.service.ProductService;
import ua.com.magazine_store.service.UserService;
import ua.com.magazine_store.service.impl.BucketServiceImpl;
import ua.com.magazine_store.service.impl.ProductServiceImpl;
import ua.com.magazine_store.service.impl.UserServiceImpl;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productId");
		Product product = productService.read(Integer.parseInt(productId));

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userService.read(userId);

		Bucket bucket = new Bucket();
		bucket.setId(UUID.randomUUID().toString());
		bucket.setProduct(product);
		bucket.setUser(user);
		bucket.setPurchaseDate(new Date());
		bucketService.create(bucket);

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}