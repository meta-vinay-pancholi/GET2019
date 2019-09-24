package com.metacube.get2019.dao;

import java.util.Map;

import com.metacube.get2019.enums.Status;
import com.metacube.get2019.model.ProductModel;

/**
 * Used for functionality related to product
 * @author Vinay
 */
public class ProductDao  {

	/**
	 * Used to create a product
	 * @param id id of product
	 * @param pName name of product
	 * @param price price of product
	 * @param pCategory category of product
	 * @param quantity quantity of product
	 * @return status
	 */
	public Status createProduct(int id, String pName, double price, String pCategory, int quantity){
		return Status.SUCCESS;
	}

	/**
	 * Used to update product
	 * @param id id of product
	 * @param quantity
	 * @return
	 */
	public Status updateProduct(int id, int quantity){
		return Status.SUCCESS;
	}

	/**
	 * Used to delete a product
	 * @param id id of product
	 * @return status
	 */
	public Status deleteProduct(int id){
		return Status.SUCCESS;
	}
	
	/**
	 * return all products;
	 * @return
	 */
	public Map<ProductModel, Integer> getAll(){
		return null;
	}
}
