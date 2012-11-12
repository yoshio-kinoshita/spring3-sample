package com.github.yoshio.service;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public Product findProduct(String name) {

		Product product = new Product();
		product.setName(name);
		product.setAmount(100);

		return product;
	}

}
