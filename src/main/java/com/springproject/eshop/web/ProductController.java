package com.springproject.eshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.eshop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ModelAndView products() {

		return new ModelAndView("index").addObject("products", productService.getAllProducts());

	}

}
