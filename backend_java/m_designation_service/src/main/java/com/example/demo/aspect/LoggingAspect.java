package com.example.demo.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LoggingAspect {
	
	private static Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Value("${eureka.instance.instance-id}")
	public String instanceId; 
	
	@ModelAttribute
	public void log() {
		logger.info("Serving through {}", instanceId);
	}

}
