package com.srvcode.jdbc.model;

import lombok.Data;

@Data
public class Product {

	private Long id;
	
	private String name;
	private String category;

	public Product() {}
	
	public Product(String name, String category) {
		this.name = name;
		this.category = category;
	}
}
