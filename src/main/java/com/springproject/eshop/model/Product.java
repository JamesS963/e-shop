package com.springproject.eshop.model;

import java.math.BigDecimal;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String name;
	private String description;
	private String category;

	@Lob
	private byte[] image;

	private BigDecimal price;

	private int quantity;

	public String coverToBaseSixtyFour() {
		return Base64.getEncoder().encodeToString(this.image);
	}
}
