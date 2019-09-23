package com.metacube.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="father_name")
	private String fathername;
	@Column(name="email")
	private String email;
	@Column(name="class")
	private String standard;
	@Column(name="age")
	private String age;
	
	public Student() {}
	
	public Student(int id, String firstname, String lastname,String fathername, String email, String standard, String age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.fathername = fathername;
		this.email = email;
		this.standard = standard;
		this.age = age;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", fathername=" + fathername + ", email=" + email
				+ ", standard=" + standard + ", age=" + age + "]";
	}
}
