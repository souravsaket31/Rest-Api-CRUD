package com.spring.concepts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.concepts.exception.ResourceNotFoundException;
import com.spring.concepts.model.Product;
import com.spring.concepts.repository.ProductRepository;

@Service
public class ProductSeviceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		Optional<Product> productDb = this.productRepository.findById(p.getId());

		if (productDb.isPresent()) {
			Product productUpdate = productDb.get();

			productUpdate.setId(p.getId());
			productUpdate.setName(p.getName());
			productUpdate.setDescription(p.getDescription());

			productRepository.save(productUpdate);

			return productUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found by ID : " + p.getId());
		}
	}

	@Override
	public Product getProductById(long pid) {
		Optional<Product> productDb = this.productRepository.findById(pid);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {

			throw new ResourceNotFoundException("Record not found by ID : " + pid);
		}

	}

	@Override
	public void deleteProduct(long pid) {

		Optional<Product> productDb = this.productRepository.findById(pid);

		if (productDb.isPresent()) {
			productRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found by ID : " + pid);

		}
		
	}


}
