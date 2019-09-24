package com.metacube.get2019.model;

/**
 * Used to create an entity of product
 * @author Vinay
 *
 */
public class ProductModel extends BaseEntity {

	private String pName;
	private double price;
	private String pCategory;

	public ProductModel() {}
	
	public ProductModel(int id, String pName, double price, String pCategory) {
		super(id);
		this.pName = pName;
		this.price = price;
		this.pCategory = pCategory;
	}

	/**
	 * Getter for name of product
	 * @return product name
	 */
	public String getpName() {
		return pName;
	}

	/**
	 * Setter for product Name
	 * @param pName
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * getter for product price
	 * @return price of product
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for price of product
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * getter for product category
 	 * @return category of product
 	 */
	public String getpCategory() {
		return pCategory;
	}

	/**
	 * setter for product category
	 * @param pCategory
	 */
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

}
