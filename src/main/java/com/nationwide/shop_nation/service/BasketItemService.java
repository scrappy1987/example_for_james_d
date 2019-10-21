package com.nationwide.shop_nation.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.nationwide.shop_nation.persistence.entity.BasketItem;
import com.nationwide.shop_nation.persistence.entity.Product;
import com.nationwide.shop_nation.persistence.repository.BasketItemRepo;

@Service
public class BasketItemService {

	@Autowired
	private BasketItemRepo repo;

	// create a mock item to prove how it works
	public BasketItem createNewItem() {
		BasketItem item = new BasketItem();
		item.setQuantity(1);
		Product product = new Product();
		product.setPrice(20.0);
		product.setProductName("name");
		item.setProduct(product);
		repo.save(item);
		return item;
	}

	public BasketItem incrementQuantity(Long id) {
		Optional<BasketItem> item = repo.findById(id);
		if (item.isPresent()) {
			item.get().setQuantity(item.get().getQuantity() + 1);
			repo.save(item.get());
		}
		return item.get();
	}
}
