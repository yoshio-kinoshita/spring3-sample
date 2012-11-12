package com.github.yoshio.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ProductServiceImplTest {
	
	@Autowired
	private ProductService productService;

	@Test
	public void findProduct() {
		Product product = productService.findProduct("test");
		assertEquals("test", product.getName());
	}

}
