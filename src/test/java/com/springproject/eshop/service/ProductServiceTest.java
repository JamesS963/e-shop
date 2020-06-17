package com.springproject.eshop.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.springproject.eshop.data.ProductRepository;
import com.springproject.eshop.model.Product;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductServiceImpl productService;

	@Mock
	private ProductRepository productRepository;

	@Test
	public void testAllProductsAreRetreivedFromDatabase() {
		List<Product> products = new ArrayList<>();
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());

		when(productRepository.findAll()).thenReturn(products);
		assertEquals(products.size(), productService.getAllProducts().size());
	}
}
