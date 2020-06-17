package com.springproject.eshop.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springproject.eshop.model.Product;
import com.springproject.eshop.security.SecurityConfig;
import com.springproject.eshop.service.ProductService;
import com.springproject.eshop.web.ProductController;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = { ProductController.class, ProductService.class, SecurityConfig.class })
public class ProductControlerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Before
	public void setup() {

	}

	@Test
	public void testThatGetProductsReturnsTheProductPageWithProducts() throws Exception {
		List<Product> products = new ArrayList<>();
		products.add(new Product());
		products.add(new Product());
		products.add(new Product());
		products.forEach(product -> {
			product.setImage(new byte[1]);
		});

		when(productService.getAllProducts()).thenReturn(products);
		mockMvc.perform(get("/products")).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(model().attribute("products", products));
	}
}
