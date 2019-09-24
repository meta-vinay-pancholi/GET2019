package com.metacube.get2019.facade;

import java.util.HashMap;
import java.util.Map;

import com.metacube.get2019.dao.InMemoryDao;
import com.metacube.get2019.enums.Status;
import com.metacube.get2019.factory.BaseFactory;
import com.metacube.get2019.model.CartModel;
import com.metacube.get2019.model.ProductModel;

/**
 * used to provide functionality of cart
 * @author Vinay
 *
 */
public class CartFacade {

	private CartModel model;
	private Map<ProductModel, Integer> productsAvailable;
	private Map<ProductModel, Integer> productsInCart;

	public CartFacade() {
		this.model = BaseFactory.createCart();
		productsInCart = new HashMap<ProductModel, Integer>();
		productsAvailable = new HashMap<ProductModel, Integer>();
	}

	/**
	 * Used to check product existence into cart
	 * @param id id of product
	 * @return boolean value
	 */
	public boolean isProduct(int id) {
		for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
			if (entry.getKey().getId() == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Used to add product into cart
	 * @param id id of product
	 * @param memoryDao 
	 * @return status
	 */
	public Status addProductToCart(int id, int quantity, InMemoryDao memoryDao) {
		if (id < 0) {
			return Status.FAILURE;
		}
		productsAvailable = memoryDao.getAll();
		if (isProduct(id)) {
			return Status.DUPLICATE;
		}
		for (Map.Entry<ProductModel, Integer> entry : productsAvailable.entrySet()) {
			if (entry.getKey().getId() == id) {
				if(quantity > entry.getValue()) {
					return Status.FAILURE;
				}
				entry.setValue(entry.getValue() - 1);
				productsInCart.put(entry.getKey(), entry.getValue());
				model.setProductsInCart(productsInCart);
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;
	}

	/**
	 * Used to remove a product from cart
	 * @param id id of product
	 * @return status
	 */
	public Status removeProductToCart(int id) {
		if (id < 0) {
			return Status.FAILURE;
		}
		for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
			if (entry.getKey().getId() == id) {
				productsInCart.remove(entry.getKey());
				model.setProductsInCart(productsInCart);
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;
	}

	/**
	 * Used to update the cart
	 * @param id if of product to be updated
	 * @param quantity 
	 * @return status
	 */
	public Status updateProductToCart(int id, int quantity) {
		if (id < 0) {
			return Status.FAILURE;
		}
		for (Map.Entry<ProductModel, Integer> entry : productsInCart.entrySet()) {
			if (entry.getKey().getId() == id) {
				entry.setValue(quantity);
				model.setProductsInCart(productsInCart);
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;
	}

	/**
	 * To get all products from cart
	 * @return cart items map
	 */
	public Map<ProductModel, Integer> getCartProducts() {
		return model.getProductsInCart();
	}
}