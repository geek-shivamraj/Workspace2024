package com.srvcode.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "hproducts")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String category;

	public Product() {}
	
	public Product(String name, String category) {
		this.name = name;
		this.category = category;
	}
}
