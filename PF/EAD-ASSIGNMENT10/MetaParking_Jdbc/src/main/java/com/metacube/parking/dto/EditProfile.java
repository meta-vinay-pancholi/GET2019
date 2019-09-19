package com.metacube.parking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class EditProfile {
	@Size(min=3, max=16)
	@NotBlank(message = "{name}" )
	@Pattern(regexp = "^[A-za-z\\s]+" , message = "{NumberNotaccepted}")
	private String fullname;
	
	@Pattern(regexp = "^[A-za-z\\s0-9]+" , message = "{passwordPattern}")
	@NotBlank(message = "{password}")
	@Size(min=8 , max =30)
	private String password;
	
	@NotBlank(message = "{password}")
	private String confirmPassword;
	
	@NotBlank(message = "{organsations}")
	private String organisation;
	
	@NotBlank(message = "{Mobile}")
	@Size(min=10 , max=10 , message="{contact}")
	@Pattern(regexp = "^[0-9]+" , message = "{validContact}")
	private String contact;

	private MultipartFile profile;
	
	
	public EditProfile() {
	}

	
	public MultipartFile getProfile() {
		return profile;
	}


	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}
	
	
	public EditProfile( String name, String email, String password,
			String confirmPassword , String organisation,
			String contact ,  MultipartFile profile) {
		this.fullname = name;

		this.password = password;
		this.confirmPassword = confirmPassword;
		this.organisation = organisation;
		this.contact = contact;
		this.profile = profile;
	}




	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
}

