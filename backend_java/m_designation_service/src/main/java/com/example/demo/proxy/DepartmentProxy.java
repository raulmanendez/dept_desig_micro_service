package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.DepartmentDTO;

@FeignClient(name = "department-service", path = "/department")
public interface DepartmentProxy {

	@GetMapping("/{id}")
	public DepartmentDTO get(@PathVariable Long id);

}
