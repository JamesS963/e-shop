package com.springproject.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.eshop.data.ProductRepository;
import com.springproject.eshop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

}
