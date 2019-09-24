package com.metacube.get2019.model;

/**
 * BaseEntity model
 * @author Vinay
 *
 */
public class BaseEntity {

	private int id;
	
	public BaseEntity() {}

	public BaseEntity(int id) {
		this.id = id;
	}

	/**
	 * Getter for id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}