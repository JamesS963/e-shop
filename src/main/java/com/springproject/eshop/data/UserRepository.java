package com.springproject.eshop.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.eshop.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
