package com.microservice.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.supplier.model.InfoSupplier;
import com.microservice.supplier.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository repository;
	
	public InfoSupplier getInfoByState(String state) {
		return repository.findByState(state);
	}
}
