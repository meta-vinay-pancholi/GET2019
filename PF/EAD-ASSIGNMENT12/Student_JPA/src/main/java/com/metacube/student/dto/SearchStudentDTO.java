package com.metacube.student.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchStudentDTO {
	@Size(min = 3, max = 30)
	@NotBlank(message = "{name}")
	@NotNull
	String firstName;
	
	@Size(min = 3, max = 30)
	@NotBlank(message = "{name}")
	@NotNull
	String lastName;
	
	public SearchStudentDTO(String firstName,String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public SearchStudentDTO() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}