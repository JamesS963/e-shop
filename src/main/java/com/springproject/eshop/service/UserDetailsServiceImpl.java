package com.springproject.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springproject.eshop.data.UserRepository;
import com.springproject.eshop.model.Basket;
import com.springproject.eshop.model.BasketItem;
import com.springproject.eshop.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Qualifier("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		return user;
	}

	public User addToBasket(BasketItem basketItem, User user) {
		log.info("basket is " + user.getBasket());
		Basket basket = user.getBasket();
		basket.getBasket().add(basketItem);
		log.info("user is " + user.toString());
		return userRepository.save(user);
	}
}
