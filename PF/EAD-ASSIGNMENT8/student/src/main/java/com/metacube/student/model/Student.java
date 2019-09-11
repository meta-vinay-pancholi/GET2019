package com.metacube.student.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	@NotBlank(message = "{blankFirstName}")
	@Size(min = 2, max = 15, message = "Name must be between {min} and {max}")
	private String firstname;

	public Student() {
	}

	public Student(String firstname, String lastname, String fathername,
			String email, String standard, String age) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.fathername = fathername;
		this.email = email;
		this.standard = standard;
		this.age = age;
	}

	@NotBlank(message = "{blankLastName}")
	@Size(min = 2, max = 15, message = "Name must be between {min} and {max}")
	private String lastname;

	@NotBlank(message = "{blankFatherName}")
	@Size(min = 2, max = 15, message = "Name must be between {min} and {max}")
	private String fathername;

	@NotBlank(message = "{blankEmail}")
	private String email;

	@NotBlank(message = "{blankClass}")
	@Pattern(regexp = "[1-12]+", message = "{validStudentClass}")
	private String standard;

	@NotBlank(message = "{blankAge}")
	@Pattern(regexp = "^[0-9]+", message = "{validAge}")
	private String age;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserCommands [firstname=" + firstname + ", lastname="
				+ lastname + ", fathername=" + fathername + ", email=" + email
				+ ", standard=" + standard + ", age =" + age + "]";
	}
}
