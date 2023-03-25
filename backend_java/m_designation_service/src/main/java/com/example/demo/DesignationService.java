package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
