package com.microservice.supplier.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.supplier.model.InfoSupplier;
import com.microservice.supplier.service.InfoService;

@RestController
@RequestMapping("/infos")
public class InfoController {

	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private InfoService service;
	
	@GetMapping("/{state}")
	public InfoSupplier getInfoByState(@PathVariable String state) {
		LOG.info("Request received at endpoint getInfoByState");
		return service.getInfoByState(state);
	}
	
}
