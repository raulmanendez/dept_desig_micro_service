package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "designation-service", path = "/MS2/designation")
public interface DesignationProxy {

	@GetMapping("/department/{id}")
	public List<DesignationDTO> getAllByDepartment(@PathVariable Long id);
}
