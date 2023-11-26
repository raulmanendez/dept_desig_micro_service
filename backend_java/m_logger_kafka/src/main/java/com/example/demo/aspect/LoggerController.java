package com.example.demo.aspect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Logger;
import com.example.demo.service.LoggerService;

@RestController
@RequestMapping("/logger")
public class LoggerController {

	@Autowired
	private LoggerService loggerService;
	
	@GetMapping
	public List<Logger> getAll() {
		return loggerService.getAll(0,10);
	}
}
