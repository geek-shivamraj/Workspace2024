package com.srvcode.jpa;

import com.srvcode.jpa.model.Product;
import com.srvcode.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Television", "Electronics"));
		productRepository.save(new Product("Air Conditioner", "Electronics"));
		productRepository.save(new Product("Sofa", "Furniture"));
		productRepository.save(new Product("Cushions", "Home Essentials"));
		productRepository.save(new Product("Wardrobe", "Furniture"));

	}
}
