package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.DesignationDTO;

@FeignClient(name = "designation-service", path = "/designation")
public interface DesignationProxy {

	@GetMapping("/department/{id}")
	public List<DesignationDTO> getAllByDepartment(@PathVariable Long id);
}
