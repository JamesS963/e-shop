package com.springproject.eshop.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springproject.eshop.model.Authority;
import com.springproject.eshop.model.Basket;
import com.springproject.eshop.model.BasketItem;
import com.springproject.eshop.model.Product;
import com.springproject.eshop.model.User;
import com.springproject.eshop.security.Role;
import com.springproject.eshop.security.SecurityConfig;
import com.springproject.eshop.service.ProductService;
import com.springproject.eshop.service.UserDetailsServiceImpl;
import com.springproject.eshop.web.BasketController;

@RunWith(SpringRunner.class)
@WebMvcTest(BasketController.class)
@ContextConfiguration(classes = { BasketController.class, ProductService.class, UserDetailsServiceImpl.class,
		SecurityConfig.class })
public class BasketControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private UserDetailsServiceImpl userService;
	@MockBean
	private Authentication auth;

	private Set<Authority> authorities;

	private User user;
	private Basket basket;
	private BasketItem basketItem;
	private List<BasketItem> basketList;

	@Before
	public void Setup() {
		userService = new UserDetailsServiceImpl();
		this.authorities = new HashSet<>();
		this.authorities.add(new Authority(1L, Role.ROLE_EMPLOYEE));
		basket = new Basket();
		this.basketList = new ArrayList<BasketItem>();
		byte[] image = new byte[1];
		image[0] = 'a';

		basketList.add(new BasketItem(1L, 2,
				new Product(1L, "product", "productDescription", "productCategory", image, new BigDecimal(1.00), 1)));

		basket.setBasket(basketList);
		user = new User(1L, "testUser", "testPassword", basket, authorities);

		when(userService.loadUserByUsername("testUser")).thenReturn(user);
		when(auth.getPrincipal()).thenReturn(user);

	}

	//problems with the user service bean i need to take a look at for testing with the "withUserDetails annotation"
//	@Test
//	@WithUserDetails
//	public void testThatBasketPageReturnsBasketPage() throws Exception {
//		mockMvc.perform(get("/basket")).andExpect(status().isOk()).andExpect(view().name("basket"));
//
//	}
}
