package com.metacube.get2019.model;

/**
 * Used to create entity of user
 * @author Vinay
 *
 */
public class UserModel extends BaseEntity {

	private String name;
	private String mobileNo;
	private String emailAddress;

	public UserModel() {}

	public UserModel(int id, String name, String mobileNo, String emailAddress) {
		super(id);
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
	}

	/**
	 * getter for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for user name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for contact Number
	 * @return contact number
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Setter for contact number
	 * @param mobileNo 
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * getter for email address
	 * @return email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * setter for emailAddress
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
