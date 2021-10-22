package com.microservice.supplier.controller;

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

	@Autowired
	private InfoService service;
	
	@GetMapping("/{state}")
	public InfoSupplier getInfoByState(@PathVariable String state) {
		return service.getInfoByState(state);
	}
	
}
