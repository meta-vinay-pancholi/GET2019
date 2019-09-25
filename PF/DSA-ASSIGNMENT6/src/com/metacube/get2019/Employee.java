package com.metacube.get2019;

/**
 * It is class to represent an employee
 * @author Vinay
 *
 */
public class Employee {

	private String empName;
	private int age;
	private int salary;
	
	/**
	 * It is a constructor to initialize employee attributes.
	 * @param empName Name of employee
	 * @param age  age of employee
	 * @param salary salary of employee
	 */
	public Employee(String empName, int age, int salary) {
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}
	
	/**
	 * It is a getter method to get name of employee.
	 * @return name of employee
	 */
	public String getName() {
		return this.empName;
	}
	
	/**
	 * It is a getter method to get age of employee
	 * @return  age of employee
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * It is a getter method to get salary of employee
	 * @return salary of employee
	 */
	public int getSalary() {
		return this.salary;
	}
}
