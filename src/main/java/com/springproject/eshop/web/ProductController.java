package com.springproject.eshop.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.eshop.form.ProductForm;
import com.springproject.eshop.model.Product;
import com.springproject.eshop.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ModelAndView getProducts() {

		return new ModelAndView("index").addObject("products", productService.getAllProducts());

	}

	@GetMapping("/product/create")
	public ModelAndView getCreateProduct() {

		return new ModelAndView("createProduct", "productForm", new ProductForm());

	}

	@PostMapping("/product/create")
	public String postCreateProduct(@Valid @ModelAttribute("productForm") ProductForm productForm, Errors errors) {
		Product product;
		try {
			log.info("product: " + productForm.toString());
			product = productForm.toProduct();
			productService.create(product);
			if(errors.hasErrors()){
				return "createProduct";
			}
		} catch (Exception e) {
			log.warn(e.toString());;
		}

		return "redirect:/products";

	}
}
