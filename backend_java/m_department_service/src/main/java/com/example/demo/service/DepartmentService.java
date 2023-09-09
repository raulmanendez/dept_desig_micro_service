package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DesignationDTO;
import com.example.demo.entity.Department;
import com.example.demo.proxy.DesignationProxy;
import com.example.demo.repository.DepartmentRepository;

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
