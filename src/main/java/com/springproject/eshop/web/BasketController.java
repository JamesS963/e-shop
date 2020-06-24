package com.springproject.eshop.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springproject.eshop.form.BasketForm;
import com.springproject.eshop.model.BasketItem;
import com.springproject.eshop.model.User;
import com.springproject.eshop.service.ProductService;
import com.springproject.eshop.service.UserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BasketController {

	private UserDetailsServiceImpl userService;
	private ProductService productService;

	public BasketController(UserDetailsServiceImpl userService, ProductService productService) {
		this.userService = userService;
		this.productService = productService;
	}

	@GetMapping("/basket")
	public String getBasket() {
		return "basket";
	}

	@PostMapping("/basket/add")
	public String addToBasket(BasketForm basketForm, @AuthenticationPrincipal User user) {
		log.info("User is" + user.toString());
		log.info("basketForm is " + basketForm.toString());
		BasketItem basketItem = new BasketItem();
		basketItem.setProduct(productService.getProduct(basketForm.getProductId()).get());
		userService.addToBasket(basketItem, user);

		return "redirect:/products";

	}
}
