package com.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Employee name is required")
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
	@Column(nullable = false)
	private String name;
	
	@NotNull(message = "Salary is required")
	@Min(value = 0, message = "Salary must be positive")
	@Column
	private int salary;
	
	@NotNull(message = "Department ID is required")
	@Min(value = 1, message = "Department ID must be at least 1")
	@Column
	private int deptid;

	public Employee() {

	}

	public Employee(String name, int salary, int deptid) {
		this.name = name;
		this.salary = salary;
		this.deptid = deptid;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

}