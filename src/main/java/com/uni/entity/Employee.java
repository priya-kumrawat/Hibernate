package com.uni.entity;

import jakarta.persistence.*;

@Entity(name="Employees")
@Table(name="employee_information")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, nullable = false)
	private int id;
	@Column(name="name", length = 55, nullable = false)
	private String name;
	private String Designation;
	private int age;
	private String email;
	@Transient // used for do not create column in table 
	private double workingHour;
	
	
	
	
	public Employee() {
	}
	
	public Employee(String name, String designation, int age, String email) {
		this.name = name;
		this.Designation = designation;
		this.age = age;
		this.email = email;
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
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getWorkingHour() {
		return workingHour;
	}

	public void setWorkingHour(double workingHour) {
		this.workingHour = workingHour;
	}


	@Override
	public String toString() {
		return "Employee \n [ id=" + id + "\n  name=" + name + "\n Designation=" + Designation + "\n age=" + age + "\n email="
				+ email + "]";
	}
	
	

}
