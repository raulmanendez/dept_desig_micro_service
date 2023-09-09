package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.DesignationDTO;
import com.example.demo.entity.Designation;
import com.example.demo.proxy.DepartmentProxy;
import com.example.demo.repository.DesignationRepository;

@Service
public class DesignationService {

	@Autowired
	private DesignationRepository designationRepository;
	
	@Autowired
	private DepartmentProxy departmentProxy;
	
	
	public void add(Designation designation) {
		designationRepository.save(designation);
	}
	
	public List<DesignationDTO> getAll() {
		
		List<DesignationDTO> list=new ArrayList<DesignationDTO>();
		for(Designation designation:designationRepository.findAll()) {
			if(designation.getDeptId()==null) continue;
			
			DepartmentDTO department=departmentProxy.get(designation.getDeptId());
			
			DesignationDTO desig=new DesignationDTO();
			desig.setId(designation.getId());
			desig.setName(designation.getName());
			desig.setDepartment(department);
			list.add(desig);
		}
		
		
		return list;
	}
	
	public List<DesignationDTO> getbyDepartmentId(Long deptId) {
		
		List<DesignationDTO> list=new ArrayList<DesignationDTO>();
		for(Designation designation:designationRepository.findByDeptId(deptId)) {
			
			DepartmentDTO department=departmentProxy.get(designation.getDeptId());
			
			DesignationDTO desig=new DesignationDTO();
			desig.setId(designation.getId());
			desig.setName(designation.getName());
			desig.setDepartment(department);
			list.add(desig);
		}
		
		
		return list;
	}
	
	
	public Designation get(Long id) {
		return designationRepository.findById(id).get();
	}
	
	public Designation remove(Long id) {
		Designation designation=get(id);
		designationRepository.deleteById(id);
		return designation;
	}
}
