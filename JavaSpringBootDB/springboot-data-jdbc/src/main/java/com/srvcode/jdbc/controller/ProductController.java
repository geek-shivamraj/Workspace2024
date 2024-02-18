package com.srvcode.jdbc.controller;

import com.srvcode.jdbc.exception.ProductNotFoundException;
import com.srvcode.jdbc.model.Product;
import com.srvcode.jdbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProduct(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/products/{pId}")
	public void deleteProduct(@PathVariable("pId") Long id) {
		productService.deleteProduct(id);
	}
}
