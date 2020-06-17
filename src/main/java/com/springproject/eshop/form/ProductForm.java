package com.springproject.eshop.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.springproject.eshop.model.Product;

import lombok.Data;

@Data
public class ProductForm {
	@NotBlank(message = "name can't be blank")
	private String name;
	@NotBlank(message = "description can't be blank")
	private String description;
	@NotBlank(message = "category can't be blank")
	private String category;

	@NotNull(message = "image can't be blank")
	private MultipartFile image;

	@DecimalMin(value = "0.00", message = "item has to atleast be more than zero")
	@Digits(integer = 4, fraction = 2, message = "must be formated like a currency")
	@NotNull(message = "price can't be empty")
	private BigDecimal price;

	@NotNull(message = "must have a quantity")
	private int quantity;

	public Product toProduct() throws Exception {
		Product product = new Product();

		product.setName(name);
		product.setDescription(description);
		product.setCategory(category);
		product.setImage(image.getBytes());
		product.setPrice(price);
		product.setQuantity(quantity);

		return product;

	}
}
