package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoggerProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void log(String message) {
		kafkaTemplate.send("logger-topic", message);
	}
}
