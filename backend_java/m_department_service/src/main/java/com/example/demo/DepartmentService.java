package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DesignationProxy designationProxy;
	
	
	public void add(Department department) {
		departmentRepository.save(department);
	}
	
	public List<Department> getAll() {
		return Streamable.of(departmentRepository.findAll()).toList();
	}
	
	public List<DesignationDTO> getAllEager(Long deptId) {
		List<DesignationDTO> list=designationProxy.getAllByDepartment(deptId);
		
		return list;
	}
	
	
	public Department get(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	public Department remove(Long id) {
		Department department=get(id);
		departmentRepository.deleteById(id);
		return department;
	}
}
