package com.springproject.eshop.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.springproject.eshop.data.UserRepository;
import com.springproject.eshop.model.Basket;
import com.springproject.eshop.model.BasketItem;
import com.springproject.eshop.model.Product;
import com.springproject.eshop.model.User;

@RunWith(SpringRunner.class)
public class UserDetailsServiceTest {
	@InjectMocks
	private UserDetailsServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUserIsRetreivedFormDatabase() {
		User user = new User();
		user.setUserId(1l);
		user.setUsername("username");
		user.setPassword("password");
		when(userRepository.findByUsername("username")).thenReturn(user);

		assertEquals(userService.loadUserByUsername("username").getUsername(), user.getUsername());
	}

	@Test
	public void testAddToBasketAddsItemToBasket() {
		Basket basket = new Basket();
		basket.setBasket(new ArrayList<BasketItem>());
		basket.getBasket().add(new BasketItem());
		User user = new User();
		user.setBasket(basket);

		when(userRepository.save(user)).thenReturn(user);

		assertEquals(userService.addToBasket(new BasketItem(), user).getBasket().getBasket().size(), 2);
	}
}
