package com.nationwide.shop_nation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.shop_nation.persistence.entity.BasketItem;
import com.nationwide.shop_nation.service.BasketItemService;

@RestController
@RequestMapping("/shop")
public class ShopNationController {
	
	@Autowired
	private BasketItemService basketService;
	
	
	@GetMapping("/createNewItem")
	public BasketItem createNewItem() {
		return basketService.createNewItem();
	}
	
	@GetMapping("/incrementQuantity/{basketId}")
	public BasketItem incrementQuantity(@PathVariable Long basketId) {
		return basketService.incrementQuantity(basketId);
	}
	
	
		
}
