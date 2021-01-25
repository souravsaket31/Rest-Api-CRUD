package com.spring.concepts.service;

import java.util.List;

import com.spring.concepts.model.Product;

public interface ProductService {

	public Product createProduct(Product p);
	
	public List<Product> getAllProduct();
	
	public Product updateProduct(Product p);
	
	public Product getProductById(long pid);
	
	void deleteProduct(long pid);

	
	
			
}
