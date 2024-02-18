package com.srvcode.hibernate.service;


import com.srvcode.hibernate.model.Product;
import com.srvcode.hibernate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		products = productRepository.getAllProduct();
		return products;
	}

	public Product getProduct(Long id) {
		return productRepository.findProductById(id);
	}

	public void addProduct(Product product) {
		productRepository.saveProduct(product);
	}

	public void updateProduct(Long id, Product product) {
		if (productRepository.findProductById(id) != null) {
			productRepository.updateProduct(product);
		}
	}

	public void deleteProduct(Long id) {
		productRepository.deleteProductById(id);
	}
}
