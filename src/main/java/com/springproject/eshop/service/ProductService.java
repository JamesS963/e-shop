package com.springproject.eshop.service;

import java.util.List;

import com.springproject.eshop.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product create(Product product);
}
