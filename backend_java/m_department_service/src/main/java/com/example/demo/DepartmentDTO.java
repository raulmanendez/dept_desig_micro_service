package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDTO {

	private Long id;
	private String name;
	private List<DesignationDTO> designations=new ArrayList<DesignationDTO>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DesignationDTO> getDesignations() {
		return designations;
	}
	public void setDesignations(List<DesignationDTO> designations) {
		this.designations = designations;
	} 
}
