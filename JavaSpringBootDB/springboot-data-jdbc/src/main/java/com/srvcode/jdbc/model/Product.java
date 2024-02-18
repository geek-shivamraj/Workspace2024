package com.srvcode.jdbc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("products")
public class Product {

	@Id
	private Long id;
	
	private String name;
	private String category;

	public Product() {}
	
	public Product(String name, String category) {
		this.name = name;
		this.category = category;
	}
}
