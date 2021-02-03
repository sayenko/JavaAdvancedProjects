package ua.com.magazine_store.service;

import java.util.Map;

import ua.com.magazine_store.domain.Product;
import ua.com.magazine_store.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product>{
	public Map<Integer, Product> readAllMap();
}
