package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/designation")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@PostMapping
	public Designation add(@RequestBody Designation Designation) {
		designationService.add(Designation);
		return Designation;
	}
	
	@GetMapping
	public List<DesignationDTO> getAll() {
		return designationService.getAll();
	}
	
	@GetMapping("/department/{id}")
	public List<DesignationDTO> getByDepartmentId(@PathVariable Long id) {
		return designationService.getbyDepartmentId(id);
	}
	
	@GetMapping("/{id}")
	public Designation get(@PathVariable Long id) {
		return designationService.get(id);
	}
	
	@DeleteMapping("{id}")
	public Designation delete(@PathVariable Long id) {
		return designationService.remove(id);
	}
}
