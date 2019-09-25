package com.metacube.get2019.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to create an entity of cart
 * @author Vinay
 */
public class CartModel {

	private Map<ProductModel, Integer> productsInCart;
	private double totalAmount;

	public CartModel() {
		this.productsInCart = new HashMap<ProductModel, Integer>();
	}

	/**
	 * Used to get products of cart
	 * @return products in cart
	 */
	public Map<ProductModel, Integer> getProductsInCart() {
		return productsInCart;
	}

	/**
	 * Used to set products in cart
	 * @param productsInCart 
	 */
	public void setProductsInCart(Map<ProductModel, Integer> productsInCart) {
		this.productsInCart = productsInCart;
	}

	/**
	 * to get total amount of products in cart
	 * @return total amount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Set total amount
	 * @param totalAmount
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
