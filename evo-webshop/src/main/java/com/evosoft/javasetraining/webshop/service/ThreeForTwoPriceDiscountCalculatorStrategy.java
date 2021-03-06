package com.evosoft.javasetraining.webshop.service;

import com.evosoft.javasetraining.webshop.model.DiscountType;
import com.evosoft.javasetraining.webshop.model.Product;

public class ThreeForTwoPriceDiscountCalculatorStrategy extends AbstractDiscountCalculatorStrategy {

	public ThreeForTwoPriceDiscountCalculatorStrategy() {
		super(DiscountType.THREE_FOR_TWO_PRICE);
	}

	public double calculatePartPrice(Product p, int numOfOrderedProduct) {

		int discountMultiplier = numOfOrderedProduct / 3;

		if(p.isDiscountStrategySupported(ThreeForTwoPriceDiscountCalculatorStrategy.class) && discountMultiplier > 0) {
			return (numOfOrderedProduct - discountMultiplier) * p.getPrice();
		}
		
		return numOfOrderedProduct * p.getPrice();
	}
}
