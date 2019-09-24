package com.metacube.get2019.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.get2019.enums.Status;
import com.metacube.get2019.factory.BaseFactory;
import com.metacube.get2019.model.ProductModel;

/**
 * In memory dao class ,here we define the functions of how to access data from memory and how to change data in memory
 * @author Vinay
 */
public class InMemoryDao extends ProductDao {

	private Map<ProductModel, Integer> productsAvailable;
	public InMemoryDao() {
		productsAvailable = new HashMap<ProductModel, Integer>();
	}

	
	public Map<ProductModel, Integer> getAll() {
		if (productsAvailable.size() == 0) {
			throw new AssertionError("No products are there");
		}
		return productsAvailable;
	}

	/**
	 * check whether the product exist or not
	 * @param id product id
	 * @return boolean value
	 */
	public boolean isProduct(int id) {
		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * used to create a product
	 * @param id
	 * @param pName name of product
	 * @param price of product
	 * @param pCategory category of product
	 * @param quantity quantity of product
	 * @return status
	 */
	public Status createProduct(int id, String pName, double price, String pCategory, int quantity) {
		if (isProduct(id)) {
			return Status.DUPLICATE;
		}
		ProductModel product = BaseFactory.createProduct(id, pName, price,
				pCategory);
		productsAvailable.put(product, quantity);
		return Status.SUCCESS;
	}
	
	/**
	 * Used to update a product
	 * @param id of product
	 * @param quantity of product
	 * @return status
	 */
	public Status updateProduct(int id, int quantity) {
		if (productsAvailable.size() == 0) {
			return Status.EMPTY;
		}
		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				entry.setValue(quantity);
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;
	}

	/**
	 * Delete a product
	 * @param id of product
	 * @return status
	 */
	public Status deleteProduct(int id) {
		if (productsAvailable.size() == 0) {
			return Status.EMPTY;
		}
		for (Map.Entry<ProductModel, Integer> entry : productsAvailable
				.entrySet()) {
			if (entry.getKey().getId() == id) {
				productsAvailable.remove(entry.getKey());
				return Status.SUCCESS;
			}
		}
		return Status.NOTFOUND;
	}
}
