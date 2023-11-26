package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Logger;
import com.example.demo.repository.LoggeRepository;

@Service
public class LoggerService {

	@Autowired
	private LoggeRepository loggerRepository;
	
	@Autowired
	private LoggerProducer loggerProducer;
	
	public void add(Logger log) {
		loggerRepository.save(log);
	}
	
	public Logger get(Long id) {
		return loggerRepository.findById(id).get();
	}
	
	public List<Logger> getAll(int page,int size) {
		loggerProducer.log("getting all logs");
		
		return loggerRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending())).getContent();
	}
	
	public Logger remove(Long id) {
		Logger log=get(id);
		loggerRepository.deleteById(id);
		return log;
	}
}
