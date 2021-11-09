package com.mbrdi.model;

public class CustomerDTO {
	
	private int id;
	private String name;
	private String dob;
	private int age;
	private String salary;
	
	public CustomerDTO() {}
	
	public CustomerDTO(int id, String name, String dob, int age, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}	

}
