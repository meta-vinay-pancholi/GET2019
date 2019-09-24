package com.metacube.parking.model;

public class EmployeeFriend {

	private int id;
	private String fullname;
	private String email;
	private String contact;
	private String organisation;
	private String gender;
	private String profile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "EmployeeFriend [id=" + id + ", fullname=" + fullname
				+ ", email=" + email + ", contact=" + contact
				+ ", organisation=" + organisation + ", gender=" + gender
				+ ", profile=" + profile + "]";
	}
	public EmployeeFriend(int id, String fullname, String email,
			String contact, String organisation, String gender, String profile) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.contact = contact;
		this.organisation = organisation;
		this.gender = gender;
		this.profile = profile;
	}
	public EmployeeFriend() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	

}
