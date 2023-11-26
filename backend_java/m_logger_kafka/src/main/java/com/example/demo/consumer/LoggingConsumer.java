package com.example.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Logger;
import com.example.demo.service.LoggerService;

@Component
public class LoggingConsumer {

	@Autowired
	private LoggerService loggerService;
	
	@KafkaListener(topics = "logger-topic", groupId = "logger-group")
	public void listen(String message) {
		// Handle received message
		System.out.println("Received Message: " + message);
		
		loggerService.add(new Logger(message));
	}
}
