package com.microservice.supplier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.supplier.model.InfoSupplier;
import com.microservice.supplier.repository.InfoRepository;

@Service
public class InfoService {

	private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);

	@Autowired
	private InfoRepository repository;
	
	public InfoSupplier getInfoByState(String state) {
		LOG.info("Searching for infoState {}", state);
		return repository.findByState(state);
	}
}
