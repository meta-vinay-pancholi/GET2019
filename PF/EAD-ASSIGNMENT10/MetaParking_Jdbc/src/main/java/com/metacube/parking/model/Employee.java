package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Employee {
	private String profile;
	private int id;
	@NotBlank(message = "{blankFullName}")
	@Size(min = 2, max = 15, message = "Name must be between {min} and {max}")
	private String fullname;
	@NotBlank(message = "{blankEmail}")
	private String email;
	@NotBlank(message = "{blankGender}")
	private String gender;
	@NotBlank(message = "{blankOrganisation}")
	private String organisation;
	@Pattern(regexp = "^[0-9]{10}+", message = "{validContact}")
	@NotBlank(message = "{blankContact}")
	private String contact;
	@NotBlank(message = "{blankPassword}")
	private String password;
	@NotBlank(message = "{blankConfirmPassword}")
	private String confirmPassword;
	
	public Employee(int id, String name, String email, String mobileNumber,
			String organisation, String gender, String password, String profile) {
		super();
		this.id = id;
		this.fullname = name;
		this.email = email;
		this.contact = mobileNumber;
		this.organisation = organisation;
		this.gender = gender;
		this.password = password;
		this.profile = profile;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", email="
				+ email + ", gender=" + gender + ", organisation="
				+ organisation + ", contact=" + contact + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ",profile="+profile+"]";
	}
	public Employee() {

	}
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPasword) {
		this.confirmPassword = confirmPasword;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}