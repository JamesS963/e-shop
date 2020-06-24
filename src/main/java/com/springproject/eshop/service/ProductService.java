package com.springproject.eshop.service;

import java.util.List;
import java.util.Optional;

import com.springproject.eshop.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Optional<Product> getProduct(Long id);
	public Product create(Product product);
}
