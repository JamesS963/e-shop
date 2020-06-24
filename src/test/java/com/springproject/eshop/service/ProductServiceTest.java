package com.springproject.eshop.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	@Test
	public void testProductIsCreated() {
		Product product = new Product();
		product.setName("name");
		when(productRepository.save(product)).thenReturn(product);

		assertEquals(product.getName(), productService.create(product).getName());

	}
	
	@Test
	public void testProductIsRetreivedFromDatabase() {
		Product product = new Product();
		product.setProductId(1L);
		when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		assertEquals(product, productService.getProduct(1L));
	}

}
