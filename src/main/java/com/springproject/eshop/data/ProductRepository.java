package com.springproject.eshop.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.eshop.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
