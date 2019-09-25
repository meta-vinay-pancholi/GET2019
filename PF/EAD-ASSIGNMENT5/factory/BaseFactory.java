package com.metacube.get2019.factory;

import com.metacube.get2019.dao.InMemoryDao;
import com.metacube.get2019.facade.CartFacade;
import com.metacube.get2019.model.CartModel;
import com.metacube.get2019.model.ProductModel;
import com.metacube.get2019.model.UserModel;

/**
 * Used to create object for entire structure
 * @author Vinay
 */
public class BaseFactory {

	/**
	 * used to create object of cartmodel
	 * @return cartModel object
	 */
	public static CartModel createCart() {
		return new CartModel();
	}

	/**
	 * used to create object of productmodel
	 * @param pId id of product
	 * @param pName name of product
	 * @param price price of product
	 * @param pCategory category of product
	 * @return product model object
	 */
	public static ProductModel createProduct(int pId, String pName,
			double price, String pCategory) {
		return new ProductModel(pId, pName, price, pCategory);
	}
	
	/**
	 * Used to create object of userModel
	 * @param id id of user
	 * @param name of user
	 * @param mobileNo of user
	 * @param emailAddress of user
	 * @return userModel object.
	 */
	public static UserModel createUser(int id, String name, String mobileNo,
			String emailAddress) {
		return new UserModel(id, name, mobileNo, emailAddress);
	}

	/**
	 * Used to create object of inmemoryDao
	 * @return inmemoryDaao object
	 */
	public static InMemoryDao createInMemoryDao() {
		return new InMemoryDao();
	}
	
	/**
	 * Used to create object of cartFacade
	 * @return cartFacade object
	 */
	public static CartFacade createCartFacade() {
		return new CartFacade();
	}
}
