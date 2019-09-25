package com.metacube.get2019.controller;

import java.util.Map;
import com.metacube.get2019.dao.ProductDao;
import com.metacube.get2019.enums.Status;
import com.metacube.get2019.factory.BaseFactory;
import com.metacube.get2019.model.ProductModel;

/**
 * base controller is used control the flow in the architecture 
 * @author Vinay
 *
*/
public class ViewController {

	private ProductDao productDao;

	public ViewController() {
			productDao = BaseFactory.createInMemoryDao();
	}

	public Map<ProductModel, Integer> getAll() {
		return productDao.getAll();
	}

	/**
	 * It is used to create a product
	 * @param id id of product
	 * @param pName name of product
	 * @param price price of product
	 * @param pCategory category of product
	 * @param quantity of product
	 * @return
	 */
	public Status createProduct(int id, String pName, double price,
			String pCategory, int quantity) {
		return productDao.createProduct(id, pName, price, pCategory, quantity);
	}

	/**
	 * used to update a product
	 * @param id of product to be updated
	 * @param quantity to which to update
	 * @return status
	 */
	public Status updateProduct(int id, int quantity) {
		return productDao.updateProduct(id, quantity);
	}

	/**
	 * delete a product from cart.
	 * @param id id of product
	 * @return status
	 */
	public Status deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}
}
