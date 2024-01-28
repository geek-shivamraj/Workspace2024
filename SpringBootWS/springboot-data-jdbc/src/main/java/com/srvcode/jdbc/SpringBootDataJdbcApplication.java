package com.srvcode.jdbc;

import com.srvcode.jdbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJdbcApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*

		productRepository.saveProduct(new Product("Television", "Electronics"));
		productRepository.saveProduct(new Product("Air Conditioner", "Electronics"));
		productRepository.saveProduct(new Product("Sofa", "Furniture"));
		productRepository.saveProduct(new Product("Cushions", "Home Essentials"));
		productRepository.saveProduct(new Product("Wardrobe", "Furniture"));

		 */
	}
}
