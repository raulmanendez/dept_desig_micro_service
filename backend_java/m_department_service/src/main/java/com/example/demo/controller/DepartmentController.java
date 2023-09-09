package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public Department add(@RequestBody Department department) {
		departmentService.add(department);
		return department;
	}
	
	@GetMapping
	public List<Department> getAll() {
		return departmentService.getAll();
	}
	
	@GetMapping("/designation/{deptId}")
	public DepartmentDTO getAllEager(@PathVariable Long deptId) {
		Department department=get(deptId);
		
		DepartmentDTO departmentDTO=new DepartmentDTO();
		departmentDTO.setId(department.getId());
		departmentDTO.setName(department.getName());
		
		departmentDTO.setDesignations(departmentService.getAllEager(deptId));
		
		return departmentDTO;
	}
	
	@GetMapping("/{id}")
	public Department get(@PathVariable Long id) {
		return departmentService.get(id);
	}
	
	@DeleteMapping("{id}")
	public Department delete(@PathVariable Long id) {
		return departmentService.remove(id);
	}
}
