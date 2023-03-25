package com.example.demo;

public class DesignationDTO {
	
	private Long id;
	private DepartmentDTO department;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
