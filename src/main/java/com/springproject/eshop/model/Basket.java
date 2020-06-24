package com.springproject.eshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private Long userId;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Basket_Product", joinColumns = @JoinColumn(name = "BASKET_ID"), inverseJoinColumns = @JoinColumn(name = "BASKET_ITEM_ID"))
	private List<BasketItem> basket;

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0.00);
		basket.forEach(item -> {
			total.add(item.getProduct().getPrice());
		});

		return total;
	}

}
